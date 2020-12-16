package com.goblindegook.adventofcode2020

fun main() {
    val seats = object {}.javaClass.getResource("/day11-input.txt").readText()
    println(countTakenSeats(seats))
}

tailrec fun countTakenSeats(seats: String, previous: String? = null): Int =
    if (seats == previous) seats.count { it == TAKEN }
    else countTakenSeats(
        seats.mapIndexed { index, seat ->
            when {
                seat == AVAILABLE && countTaken(seats, index) == 0 -> TAKEN
                seat == TAKEN && countTaken(seats, index) >= 4 -> AVAILABLE
                else -> seat
            }
        }.joinToString(""),
        seats
    )

private const val NEW_LINE = '\n'
private const val TAKEN = '#'
private const val AVAILABLE = 'L'

private fun countTaken(seats: String, index: Int) =
    neighbours(index, seats.indexOf(NEW_LINE) + 1)
        .count { neighbour -> seats.getOrNull(neighbour) == TAKEN }

private fun neighbours(index: Int, width: Int) =
    listOfNotNull(
        (index - 1).takeIf { it % width != width },
        index,
        (index + 1).takeIf { it % width != 0 }
    )
        .flatMap { listOf(it - width, it, it + width) }
        .filter { it != index }