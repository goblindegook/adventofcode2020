package com.goblindegook.adventofcode2020

import com.goblindegook.adventofcode2020.extension.plus
import com.goblindegook.adventofcode2020.extension.times
import com.goblindegook.adventofcode2020.extension.toIntOr
import com.goblindegook.adventofcode2020.input.load
import kotlin.math.PI
import kotlin.math.absoluteValue
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    val instructions = load("/day12-input.txt")
    println(navigateShip(instructions))
    println(navigateShipByWaypoint(instructions))
}

fun navigateShip(instructions: String): Int = instructions
    .lines()
    .map { it.substring(0, 1) to (it.substring(1).toIntOr(0)) }
    .fold(0 to 0) { (distance, degrees), (command, value) ->
        when (command) {
            "S", "E" -> distance + value to degrees
            "N", "W" -> distance - value to degrees
            "F" -> distance + value * factor(degrees) to degrees
            "L" -> distance to degrees + value
            "R" -> distance to degrees - value
            else -> distance to degrees
        }
    }.first.absoluteValue

fun navigateShipByWaypoint(instructions: String): Int = instructions
    .lines()
    .map { it.substring(0, 1) to (it.substring(1).toIntOr(0)) }
    .fold((0 to 0) to (10 to -1)) { (ship, waypoint), (command, value) ->
        when (command) {
            "S" -> ship to waypoint + (0 to value)
            "E" -> ship to waypoint + (value to 0)
            "N" -> ship to waypoint + (0 to -value)
            "W" -> ship to waypoint + (-value to 0)
            "F" -> ship + (waypoint * value) to waypoint
            "L" -> ship to waypoint.rotate(-value)
            "R" -> ship to waypoint.rotate(value)
            else -> ship to waypoint
        }
    }.first.let { (x, y) -> x.absoluteValue + y.absoluteValue }

private inline val Int.radianValue: Double get() = this * PI / 180.0

private fun factor(deg: Int) = cos(deg.radianValue).toInt() - sin(deg.radianValue).toInt()

private fun Pair<Int, Int>.rotate(deg: Int) =
    (this * cos(deg.radianValue).toInt()) + ((-second to first) * sin(deg.radianValue).toInt())