package com.goblindegook.adventofcode2020

import java.math.BigInteger

fun main() {
    val data = object {}.javaClass.getResource("/day09-input.txt").readText()
    println(findXmasWeakness(data, 25))
}

fun findXmasWeakness(data: String, preamble: Int): BigInteger? = data
    .lines()
    .map(String::toBigInteger)
    .windowed(preamble + 1)
    .find { window ->
        window.withIndex().none { n -> window.drop(n.index + 1).any { m -> n.value + m == window.last() } }
    }
    ?.last()