# BATT
## Benchmark All The Things

This project aims to be a fairly comprehensive benchmark suite for many languages doing many things.

Most existing benchmarks are fairly simple, and try to determine which of two things is faster. In the real world,
however, there is very rarely one that is always faster. This suite attempts to test things in as many ways as
possible, for slightly more complete information. The hope is that it can be useful for determining what is 
"fast enough" for your situation.

## Requirements

The benchmarker is writen in Scala and uses SBT, and thus requires scala and SBT to run. Individiual benchmarks will
require their language's tools to run. In order to get instruction counts, valgrind must be available.

## How to use

TODO

## Current list of benchmarks:
- None

## License

```
BATT is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

BATT is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with BATT.  If not, see <http://www.gnu.org/licenses/>.
```