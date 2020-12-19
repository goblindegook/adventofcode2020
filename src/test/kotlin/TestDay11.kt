package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay11 {
    @Test
    fun `people don't sit on the floor`() {
        val data = """
            .
            .
        """.trimIndent()

        assertEquals(0, countSeated(data))
        assertEquals(0, countSeatedRedux(data))
    }

    @Test
    fun `a single empty seat becomes occupied`() {
        val data = """
            L
            .
        """.trimIndent()

        assertEquals(1, countSeated(data))
        assertEquals(1, countSeatedRedux(data))
    }

    @Test
    fun `adjacent seats where one is occupied and the other is not are stable`() {
        val data = """
            L#
            ..
        """.trimIndent()

        assertEquals(1, countSeated(data))
        assertEquals(1, countSeatedRedux(data))
    }

    @Test
    fun `a seat with 4 or more occupied seats around it becomes empty`() {
        val data = """
            .#.
            ###
            .#.
        """.trimIndent()

        assertEquals(4, countSeated(data))
    }

    @Test
    fun `37 occupied seats in the example`() {
        val data = """
            L.LL.LL.LL
            LLLLLLL.LL
            L.L.L..L..
            LLLL.LL.LL
            L.LL.LL.LL
            L.LLLLL.LL
            ..L.L.....
            LLLLLLLLLL
            L.LLLLLL.L
            L.LLLLL.LL
        """.trimIndent()

        assertEquals(37, countSeated(data))
    }

    @Test
    fun `a seat with 4 occupied seats stays taken`() {
        val data = """
            .#.
            ###
            .#.
        """.trimIndent()

        assertEquals(5, countSeatedRedux(data))
    }

    @Test
    fun `a seat with 5 or more occupied seats becomes empty`() {
        val data = """
            .##
            ###
            .#.
        """.trimIndent()

        assertEquals(5, countSeatedRedux(data))
    }

    @Test
    fun `a seat with a taken seat in the line of sight stays empty (redux)`() {
        val data = """
            ##...
            #L.#.
            .#...
        """.trimIndent()

        assertEquals(5, countSeatedRedux(data))
    }

    @Test
    fun `26 occupied seats in the example (redux)`() {
        val data = """
            L.LL.LL.LL
            LLLLLLL.LL
            L.L.L..L..
            LLLL.LL.LL
            L.LL.LL.LL
            L.LLLLL.LL
            ..L.L.....
            LLLLLLLLLL
            L.LLLLLL.L
            L.LLLLL.LL
        """.trimIndent()

        assertEquals(26, countSeatedRedux(data))
    }
}