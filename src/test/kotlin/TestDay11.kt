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

        assertEquals(0, countTakenSeats(data))
    }

    @Test
    fun `a single empty seat becomes occupied`() {
        val data = """
            L
            .
        """.trimIndent()

        assertEquals(1, countTakenSeats(data))
    }

    @Test
    fun `adjacent seats where one is occupied and the other is not are stable`() {
        val data = """
            L#
            ..
        """.trimIndent()

        assertEquals(1, countTakenSeats(data))
    }

    @Test
    fun `a seat with 4 or more occupied seats around it becomes empty`() {
        val data = """
            .#.
            ###
            .#.
        """.trimIndent()

        assertEquals(4, countTakenSeats(data))
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

        assertEquals(37, countTakenSeats(data))
    }
}