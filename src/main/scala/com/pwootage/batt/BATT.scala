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

package com.pwootage.batt

import java.io.File

import com.pwootage.batt.benchmarks.{BenchmarkResult, Benchmark, ExternalProcessBenchmark}

/**
 * Main entry-point for BATT
 *
 * Created by pwootage on 9/5/14.
 */
object BATT {
  def main(args: Array[String]) {
    val benchmarksToRun = Seq[Benchmark](
      new ExternalProcessBenchmark("scala-wordcount-split", new File("benchmarks/scala/scala-wordcount"))("scala", "WordCount_Split"),
      new ExternalProcessBenchmark("scala-wordcount-streaming-space-count", new File("benchmarks/scala/scala-wordcount"))("scala", "Word_Count_Streaming_Space_Count"),
      new ExternalProcessBenchmark("python-wordcount-split", new File("benchmarks/python/python-wordcount"))("python3", "wordcount-split.py"),
      new ExternalProcessBenchmark("python-wordcount-streaming-space-count", new File("benchmarks/python/python-wordcount"))("python3", "wordcount-streaming-space-count.py")
    )
    val res = benchmarksToRun.map(b => executeBenchmark(b))
    res.foreach(res => println(res match {
      case Some(x) => x.name + " -> " + x.normalizedScore
      case None => ""
    }))
  }

  def executeBenchmark(b: Benchmark): Option[BenchmarkResult] = {
    if (b.compile() != 0) None else Some(avg(10, b.run))
  }

  def avg(count: Int, exec: () => BenchmarkResult): BenchmarkResult = {
    (1 to count).map(_ => exec.apply()).reduce(_ + _) / count
  }
}
