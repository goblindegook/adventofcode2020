package com.goblindegook.adventofcode2020

import com.goblindegook.adventofcode2020.input.load

fun main() {
    val passwords = load("/day02-input.txt").lines()
    println(passwords.count(::isSledPasswordValid))
    println(passwords.count(::isTobogganPasswordValid))
}

fun isSledPasswordValid(entry: String): Boolean =
    entry.parsePasswordPolicy()?.let { (first, second, char, password) ->
        password.count { it == char[0] } in first.toInt()..second.toInt()
    } ?: false

fun isTobogganPasswordValid(entry: String): Boolean =
    entry.parsePasswordPolicy()?.let { (first, second, char, password) ->
        (password[first.toInt() - 1] == char[0]) xor (password[second.toInt() - 1] == char[0])
    } ?: false

private fun String.parsePasswordPolicy() =
    Regex("""(\d+)-(\d+) (\w): (\w+)""").matchEntire(this)?.destructured