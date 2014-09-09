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

import scala.io.Source

object WordCount_Split {
  def main(args: Array[String]): Unit = {
    val mode = args(0)
    val start = System.nanoTime()
    val src = Source.fromFile("../../../fixtures/war_and_peace.txt")
    val wap = src.mkString
    src.close()
    var count = 0
    if (mode == "RUN") {
      count = wap.split(" ").length
    } else {
      count = 514908
    }
    val end = System.nanoTime()
    val time = (end - start).toDouble / 1000000000D

    if (count != 514908) {
      System.err.println("GOT WRONG COUNT (expected " + 514908 + " got " + count)
      System.exit(1)
    }

    //Can't be fancier about this score than just dividing by the time, so bigger = better
    val score = (10000D / time).toLong
    println("time " + time)
    println("score " + score)
   }
}
