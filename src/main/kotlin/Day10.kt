package com.goblindegook.adventofcode2020

fun main() {
    val data = object {}.javaClass.getResource("/day10-input.txt").readText()
    val adapters = data.lines().map(String::toInt)
    println(joltageDiffsMultiplied(adapters))
}

tailrec fun joltageDiffsMultiplied(adapters: List<Int>, diff1: Int = 1, diff3: Int = 1, joltage: Int = 1): Int =
    when {
        joltage + 1 in adapters -> joltageDiffsMultiplied(adapters, diff1 + 1, diff3, joltage + 1)
        joltage + 3 in adapters -> joltageDiffsMultiplied(adapters, diff1, diff3 + 1, joltage + 3)
        else -> diff1 * diff3
    }