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
 * The result of running a benchmark.
 */
case class BenchmarkResult(name: String,
                           normalizedScore: Double,
                           timeSeconds: Double,
                           instructions: Long = -1) {
  def +(other: BenchmarkResult) = BenchmarkResult(
    name,
    normalizedScore + other.normalizedScore,
    timeSeconds + other.timeSeconds,
    instructions + other.instructions
  )

  def -(other: BenchmarkResult) = BenchmarkResult(
    name,
    normalizedScore - other.normalizedScore,
    timeSeconds - other.timeSeconds,
    instructions - other.instructions
  )

  def /(other: Double) = BenchmarkResult(
    name,
    normalizedScore / other,
    timeSeconds / other,
    instructions / other.toLong
  )


}
