/*
 * Copyright (c) 2014 Pwootage
 *
 * This file is part of Foobar.
 *
 * com.maddyhome.idea.copyright.pattern.ProjectInfo@733e1169 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * com.maddyhome.idea.copyright.pattern.ProjectInfo@733e1169 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with com.maddyhome.idea.copyright.pattern.ProjectInfo@733e1169.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.pwootage.batt.benchmarks

/**
 * Generic implementations for running benchmarks
 *
 * Created by pwootage on 9/5/14.
 */
object benchmarks {
  class ExternalProcessBenchmark(val executable: String, val args: Array[String]) extends Benchmark {
    override def run(): BenchmarkResult = ???
  }
}
