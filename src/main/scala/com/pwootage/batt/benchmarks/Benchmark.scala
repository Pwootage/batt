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

/**
 * Base benchmark trait. Every benchmark must do these things.
 *
 * Created by pwootage on 9/5/14.
 */
trait Benchmark {
  val RUN_STRING = "RUN"
  val BASELINE_STRING = "BASELINE"

  /**
   * This method will be called prior to [[Benchmark.baseline()]] or [[Benchmark.baseline()]].
   * It is useful for compiling the benchmark or doing other setup. Will (by default) execute
   * compile.scala in the benchmark's basedir.
   *
   * @return Process exit code of compile.scala
   */
  def compile(): Int

  /**
   * Should return a baseline value; equivalent to running the benchmark and doing nothing else.
   * @return Baseline results
   */
  def baseline(): BenchmarkResult

  /**
   * Run the benchmark return the results of your benchmarks. Do not take into account the baseline,
   * that will happen automatically
   *
   * @return Benchmark Results
   */
  def run(): BenchmarkResult
}
