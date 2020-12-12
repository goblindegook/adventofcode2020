package com.goblindegook.adventofcode2020

fun main() {
    val program = object {}.javaClass.getResource("/day08-input.txt").readText()
    println(runUntilLoop(program))
    println(runProgram(program))
}

fun runUntilLoop(program: String): Int = program.lines()
    .map { line -> line.split(" ").let { it[0] to it[1].toInt() } }
    .runUntilLoop(0, 0, emptyList())

private fun List<Pair<String, Int>>.runUntilLoop(acc: Int, cur: Int, trace: List<Int>): Int =
    if (cur in trace) acc
    else get(cur).let { (instruction, offset) ->
        when (instruction) {
            "acc" -> runUntilLoop(acc + offset, cur + 1, trace + cur)
            "jmp" -> runUntilLoop(acc, cur + offset, trace + cur)
            else -> runUntilLoop(acc, cur + 1, trace + cur)
        }
    }

fun runProgram(program: String): Int = program.lines()
    .map { line -> line.split(" ").let { it[0] to it[1].toInt() } }
    .runProgram(0, 0, emptyList())

/**
 * Because we know there's a single bug in the program, we can unconditionally explore the alternative first using
 * `runFixedProgram()`, then fallback to the program as written if we hit a loop.
 */
private fun List<Pair<String, Int>>.runProgram(acc: Int, cur: Int, trace: List<Int>): Int =
    if (cur !in indices) acc
    else get(cur).let { (instruction, offset) ->
        when (instruction) {
            "acc" -> runProgram(acc + offset, cur + 1, trace + cur)
            "jmp" -> runFixedProgram(acc, cur + 1, trace + cur) ?: runProgram(acc, cur + offset, trace + cur)
            else -> runFixedProgram(acc, cur + offset, trace + cur) ?: runProgram(acc, cur + 1, trace + cur)
        }
    }

private fun List<Pair<String, Int>>.runFixedProgram(acc: Int, cur: Int, trace: List<Int>): Int? =
    when (cur) {
        !in indices -> acc
        in trace -> null
        else -> get(cur).let { (instruction, offset) ->
            when (instruction) {
                "acc" -> runFixedProgram(acc + offset, cur + 1, trace + cur)
                "jmp" -> runFixedProgram(acc, cur + offset, trace + cur)
                else -> runFixedProgram(acc, cur + 1, trace + cur)
            }
        }
    }
