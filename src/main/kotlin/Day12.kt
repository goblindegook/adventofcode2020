package com.goblindegook.adventofcode2020

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    val instructions = object {}.javaClass.getResource("/day12-input.txt").readText()
    println(navigateShip(instructions))
}

fun navigateShip(instructions: String): Int = instructions
    .lines()
    .map { it.substring(0, 1) to (it.substring(1).toIntOrNull() ?: 0) }
    .fold(0 to 0) { (distance, degrees), (command, value) ->
        when (command) {
            "S", "E"  -> distance + value to degrees
            "N", "W"  -> distance - value to degrees
            "F"  -> distance + value * (degrees * PI / 180.0).let { cos(it).toInt() - sin(it).toInt() } to degrees
            "L"  -> distance to degrees + value
            "R"  -> distance to degrees - value
            else -> distance to degrees
        }
    }.first
