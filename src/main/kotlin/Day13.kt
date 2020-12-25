package com.goblindegook.adventofcode2020

import com.goblindegook.adventofcode2020.input.load

fun main() {
    val data = load("/day13-input.txt").lines()
    val timestamp = data[0].toInt()
    val buses = data[1].split(",").map(String::toIntOrNull)

    println(earliestBus(timestamp, buses)?.let { it.first * it.second })
}

fun earliestBus(timestamp: Int, buses: List<Int?>): Pair<Int, Int>? = buses
    .filterNotNull()
    .map { it to timeToWait(timestamp, it) }
    .minByOrNull { it.second }

private fun timeToWait(timestamp: Int, bus: Int): Int = ((timestamp / bus) * bus + bus - timestamp).takeIf { it != bus } ?: 0