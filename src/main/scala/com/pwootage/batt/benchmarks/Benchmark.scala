/*
 * Copyright (c) 2014 Pwootage
 *
 * This file is part of Foobar.
 *
 * com.maddyhome.idea.copyright.pattern.ProjectInfo@7e2e27ae is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * com.maddyhome.idea.copyright.pattern.ProjectInfo@7e2e27ae is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with com.maddyhome.idea.copyright.pattern.ProjectInfo@7e2e27ae.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.pwootage.batt.benchmarks

/**
 * Base benchmark trait. Every benchmark must do these things.
 *
 * Created by pwootage on 9/5/14.
 */
trait Benchmark {
  def run(): BenchmarkResult
}
