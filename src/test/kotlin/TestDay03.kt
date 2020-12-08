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

        assertEquals(0, Map(map).treeCount(3, 1))
    }

    @Test
    fun `find one tree`() {
        val map = """
            ....
            ...#
        """.trimIndent()

        assertEquals(1, Map(map).treeCount(3, 1))
    }

    @Test
    fun `find two trees`() {
        val map = """
            ...
            .#.
            ..#
        """.trimIndent()

        assertEquals(2, Map(map).treeCount(1, 1))
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

        assertEquals(7, Map(map).treeCount(3, 1))
    }
}