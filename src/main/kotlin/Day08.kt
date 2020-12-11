package com.goblindegook.adventofcode2020

fun main() {
    val program = object {}.javaClass.getResource("/day08-input.txt").readText()
    println(accumulatorBeforeLoop(program))
}

fun accumulatorBeforeLoop(program: String): Int = program
    .lines()
    .map { line -> line.split(" ").let { it[0] to it[1].toInt() } }
    .accumulatorOnLoop(0, 0, emptyList())

private fun List<Pair<String, Int>>.accumulatorOnLoop(acc: Int, cur: Int, trace: List<Int>): Int =
    if (cur in trace) acc
    else get(cur).let { (instruction, offset) ->
        when (instruction) {
            "acc" -> accumulatorOnLoop(acc + offset, cur + 1, trace + cur)
            "jmp" -> accumulatorOnLoop(acc, cur + offset, trace + cur)
            else -> accumulatorOnLoop(acc, cur + 1, trace + cur)
        }
    }