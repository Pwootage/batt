/*
 * Copyright (c) 2014 Pwootage
 *
 * This file is part of Foobar.
 *
 * com.maddyhome.idea.copyright.pattern.ProjectInfo@c683f4a is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * com.maddyhome.idea.copyright.pattern.ProjectInfo@c683f4a is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with com.maddyhome.idea.copyright.pattern.ProjectInfo@c683f4a.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.pwootage.batt.benchmarks

/**
 * Created by pwootage on 9/5/14.
 */
case class BenchmarkResult(name: String,
                           normalizedScore: Int,
                           timeSeconds: Double,
                           instructions: Long = -1) {
}
