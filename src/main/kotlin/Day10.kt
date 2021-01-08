package com.goblindegook.adventofcode2020

import com.goblindegook.adventofcode2020.extension.asIntList
import com.goblindegook.adventofcode2020.input.load

fun main() {
    val adapters = load("/day10-input.txt").asIntList()
    println(multiplyJoltageDiffs(adapters))
    println(countPermutations(adapters))
}

tailrec fun multiplyJoltageDiffs(adapters: List<Int>, diff1: Int = 1, diff3: Int = 1, joltage: Int = 1): Int =
    when {
        joltage + 1 in adapters -> multiplyJoltageDiffs(adapters, diff1 + 1, diff3, joltage + 1)
        joltage + 2 in adapters -> multiplyJoltageDiffs(adapters, diff1, diff3, joltage + 2)
        joltage + 3 in adapters -> multiplyJoltageDiffs(adapters, diff1, diff3 + 1, joltage + 3)
        else -> diff1 * diff3
    }

fun countPermutations(adapters: List<Int>): Long = adapters
    .sorted()
    .fold(mapOf(0 to 1L)) { counts, jolts ->
        counts + (jolts to counts.filterKeys { it in jolts - 3 until jolts }.values.sum())
    }
    .values
    .last()