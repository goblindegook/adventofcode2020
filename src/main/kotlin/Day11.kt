package com.goblindegook.adventofcode2020

fun main() {
    val seats = object {}.javaClass.getResource("/day11-input.txt").readText()
    println(countTakenSeats(seats))
}

fun countTakenSeats(seats: String): Int = countTakenSeats(seats.toCharMap(), emptyMap())

private const val NEW_LINE = '\n'
private const val TAKEN = '#'
private const val AVAILABLE = 'L'

private fun String.toCharMap(): Map<Pair<Int, Int>, Char> =
    foldIndexed(emptyMap()) { index, acc, char -> acc + (coordinatesFrom(index) to char) }

private fun String.coordinatesFrom(index: Int) = (indexOf(NEW_LINE) + 1).let { index % it to index / it }

private tailrec fun countTakenSeats(seats: Map<Pair<Int, Int>, Char>, previous: Map<Pair<Int, Int>, Char>): Int =
    if (seats == previous) seats.values.count { it == TAKEN }
    else countTakenSeats(
        seats.mapValues { (position, state) ->
            when {
                state == AVAILABLE && seats.seatedNeighbours(position) == 0 -> TAKEN
                state == TAKEN && seats.seatedNeighbours(position) >= 4 -> AVAILABLE
                else -> state
            }
        },
        seats
    )

private fun Map<Pair<Int, Int>, Char>.seatedNeighbours(pos: Pair<Int, Int>) = pos
    .let { (x, y) ->
        setOf(
            x - 1 to y - 1, x - 1 to y, x - 1 to y + 1,
            x to y - 1, x to y + 1,
            x + 1 to y - 1, x + 1 to y, x + 1 to y + 1
        )
    }
    .count { get(it) == TAKEN }