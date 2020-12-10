package com.goblindegook.adventofcode2020

import java.math.BigInteger

fun main() {
    val input = object {}.javaClass.getResource("/day03-input.txt").readText()
    val map = Map(input)

    println(map.treeCount(3, 1))

    println(
        setOf(
            map.treeCount(1, 1),
            map.treeCount(3, 1),
            map.treeCount(5, 1),
            map.treeCount(7, 1),
            map.treeCount(1, 2),
        ).map(Int::toBigInteger).reduce(BigInteger::times)
    )
}

class Map(private val map: String) {
    private val width = map.indexOf(NEW_LINE)
    private val height = map.count { it == NEW_LINE }

    fun treeCount(stepRight: Int, stepDown: Int): Int =
        treeCount(0, 0, 0, stepRight, stepDown)

    private fun treeCount(answer: Int, x: Int, y: Int, stepRight: Int, stepDown: Int): Int =
        if (y > height) answer
        else treeCount(
            answer + if (map.get(x, y) == TREE) 1 else 0,
            x + stepRight,
            y + stepDown,
            stepRight,
            stepDown
        )

    private fun String.get(x: Int, y: Int) = get(y * (width + 1) + (x % width))

    companion object {
        private const val NEW_LINE = '\n'
        private const val TREE = '#'
    }
}
