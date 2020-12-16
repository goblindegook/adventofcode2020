package com.goblindegook.adventofcode2020

import java.math.BigInteger

fun main() {
    val data = object {}.javaClass.getResource("/day10-input.txt").readText()
    val adapters = data.lines().map(String::toInt)
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

fun countPermutations(adapters: List<Int>): BigInteger? = adapters
    .sorted()
    .fold(mapOf(0 to 1.toBigInteger())) { counts, jolts ->
        counts + (jolts to counts.filterKeys { it in jolts - 3 until jolts }.values.sumOf { it })
    }
    .toSortedMap()
    .values
    .last()