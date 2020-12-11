package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay08 {
    @Test
    fun `handle jmp 0`() {
        val input = "jmp 0"

        assertEquals(0, accumulatorBeforeLoop(input))
    }

    @Test
    fun `handle acc +1, jmp -1`() {
        val input = """
            acc +1
            jmp -1
        """.trimIndent()

        assertEquals(1, accumulatorBeforeLoop(input))
    }

    @Test
    fun `handle acc -1, jmp -1`() {
        val input = """
            acc -1
            jmp -1
        """.trimIndent()

        assertEquals(-1, accumulatorBeforeLoop(input))
    }

    @Test
    fun `handle nop`() {
        val input = """
            nop +99
            jmp -1
        """.trimIndent()

        assertEquals(0, accumulatorBeforeLoop(input))
    }

    @Test
    fun `accumulator is 5 before the program loops`() {
        val input = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
        """.trimIndent()

        assertEquals(5, accumulatorBeforeLoop(input))
    }
}