package com.goblindegook.adventofcode2020.extension

infix operator fun Pair<Int, Int>.plus(pair: Pair<Int, Int>) = first + pair.first to second + pair.second

infix operator fun Pair<Int, Int>.times(multiplier: Int) = first * multiplier to second * multiplier