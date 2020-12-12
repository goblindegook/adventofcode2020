package com.goblindegook.adventofcode2020

import java.lang.Integer.parseInt

fun main() {
    val input = object {}.javaClass.getResource("/day05-input.txt").readText()
    val boardingPasses = input.lines()
    println(boardingPasses.map(::seatId).maxOrNull())
    println(findEmptySeat(boardingPasses))
}

fun seatId(boardingPass: String): Int = boardingPass
    .replace(Regex("[FL]"), "0")
    .replace(Regex("[BR]"), "1")
    .let { parseInt(it, 2) }

fun findEmptySeat(boardingPasses: List<String>): Int = boardingPasses
    .map(::seatId)
    .sorted()
    .run { first { !contains(it + 1) } } + 1