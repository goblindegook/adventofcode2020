package com.goblindegook.adventofcode2020

fun main() {
    val seats = object {}.javaClass.getResource("/day11-input.txt").readText()
    println(countSeated(seats))
    println(countSeatedRedux(seats))
}

fun countSeated(seats: String): Int = countSeated(seats.toRoom(), emptyMap(), 4, ::neighbours)
fun countSeatedRedux(seats: String): Int = countSeated(seats.toRoom(), emptyMap(), 5, ::lineOfSight)

private const val NEW_LINE = '\n'
private const val TAKEN = '#'
private const val AVAILABLE = 'L'
private const val FLOOR = '.'

private tailrec fun countSeated(room: Room, previous: Room, limit: Int, count: (Room, Position) -> Int): Int =
    if (room == previous) room.values.count { it == TAKEN }
    else countSeated(
        room.mapValues { (position, state) ->
            when {
                state == AVAILABLE && count(room, position) == 0 -> TAKEN
                state == TAKEN && count(room, position) >= limit -> AVAILABLE
                else -> state
            }
        },
        room,
        limit,
        count
    )

private fun neighbours(seats: Room, pos: Position): Int =
    Position.around.map { pos + it }.count { seats[it] == TAKEN }

private fun lineOfSight(room: Room, position: Position): Int =
    lineOfSight(room, 0, Position.around.map { position to it })

private tailrec fun lineOfSight(room: Room, found: Int, queue: List<Pair<Position, Position>>): Int =
    if (queue.isEmpty()) found
    else {
        val head = queue.first()
        val step = head.second
        val seat = head.first + step
        lineOfSight(
            room = room,
            found = found + if (room[seat] == TAKEN) 1 else 0,
            queue = (queue + (seat to step).takeIf { room[seat] == FLOOR }).drop(1).filterNotNull()
        )
    }

private data class Position(val x: Int, val y: Int) {
    infix operator fun plus(other: Position) = Position(x + other.x, y + other.y)

    companion object {
        val around = listOf(
            Position(-1, -1), Position(-1, 0), Position(-1, +1),
            Position(0, -1), Position(0, +1),
            Position(+1, -1), Position(+1, 0), Position(+1, +1),
        )
    }
}

private typealias Room = Map<Position, Char>

private fun String.toRoom(): Room =
    foldIndexed(emptyMap()) { index, acc, char -> acc + (positionOf(index) to char) }

private fun String.positionOf(index: Int) = (indexOf(NEW_LINE) + 1).let { Position(index % it, index / it) }