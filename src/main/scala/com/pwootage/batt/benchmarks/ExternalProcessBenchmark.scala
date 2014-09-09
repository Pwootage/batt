/*
 * Copyright (c) 2014 Pwootage
 *
 * This file is part of batt.
 *
 * batt is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * batt is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with batt.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.pwootage.batt.benchmarks

import java.io._
import scala.io._
import java.nio.charset.StandardCharsets

import com.pwootage.batt.benchmarks.ConfigMethod._

import scala.sys.process._

/**
 * Runs a benchmark in an external process. This is the standard way of running a benchmark.
 * By default, it will to execute a "compile.scala" in the base dir as a compile step,
 * should it exist.
 * <br/><br/>
 *
 * It is expected that the process will check whether to run the benchmark or run the baseline
 * with one of the following methods, configured via the <code>confMethod</code> paramteter:
 * <ul>
 * <li>Environment variable BENCH_MODE (default)</li>
 * <li>Standard Input</li>
 * <li>Command line arguments</li>
 * </ul>
 * In any case, the input will consist of the following:
 * <br /><br/>
 * The value "<code>BASELINE</code>", in which case the code should run everything *except* the benchmark
 * <br/>or<br/>
 * the value "<code>RUN</code>", in which case the code should execute the benchmark.
 *
 * <br/><br />
 * The process will then produce it's output using one of the following methods:
 * <ul>
 * <li>Standard Output</li>
 * <li>Writing to a file</li>
 * </ul>
 *
 * The output should be formatted as follows:
 * <br/><br />
 * <pre>
 * time 11.62234
 * score 19968
 * </pre>
 * where the number after time is the number of seconds the benchmark ran, and score is the normalized score.
 *
 * @param name Name of this benchmark
 * @param confMethod Method to configure the execution
 * @param command Command to execute
 */
class ExternalProcessBenchmark(val name: String, val baseDir: File, val confMethod: ConfigMethod = CommandLineArgs)(val command: String*) extends Benchmark {

  override def compile(): Int = {
    val compileFile = new File(baseDir, "compile.scala")
    if (compileFile.exists()) {
      println("running compile.scala for " + name)
      Process(Seq("scala", "compile.scala"), baseDir).!<
    } else 0
  }

  override def run(): BenchmarkResult = {
    parseResults(execute('run))
  }

  override def baseline(): BenchmarkResult = {
    parseResults(execute('base))
  }

  def execute(mode: Symbol): String = {
    println("Executing " + name + " in mode " + mode)
    val modeString = mode match {
      case 'run => RUN_STRING
      case 'base => BASELINE_STRING
    }
    confMethod match {
      case StandardIn => Process(command, baseDir).#<(new ByteArrayInputStream(modeString.getBytes(StandardCharsets.UTF_8))).!!
      case EnvironmentVariable => Process(command, baseDir, "BENCH_MODE" -> modeString).!!
      case CommandLineArgs => Process(command ++ Seq(modeString), baseDir).!!
    }
  }

  def parseResults(res: String): BenchmarkResult = {
    val split = res.split("\\s")
    BenchmarkResult(name, split(3).toInt, split(1).toDouble)
  }
}