package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay03 {
    @Test
    fun `find no trees`() {
        val map = """
            ....
            ....
        """.trimIndent()

        assertEquals(0, treeCount(3, 1, map))
    }

    @Test
    fun `find one tree`() {
        val map = """
            ....
            ...#
        """.trimIndent()

        assertEquals(1, treeCount(3, 1, map))
    }

    @Test
    fun `find two trees`() {
        val map = """
            ...
            .#.
            ..#
        """.trimIndent()

        assertEquals(2, treeCount(1, 1, map))
    }

    @Test
    fun `find trees from example`() {
        val map = """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
        """.trimIndent()

        assertEquals(7, treeCount(3, 1, map))
    }
}