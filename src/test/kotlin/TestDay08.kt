package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay08 {
    @Test
    fun `handle loops with jmp 0`() {
        val input = "jmp 0"

        assertEquals(0, runUntilLoop(input))
    }

    @Test
    fun `handle loops with acc +1, jmp -1`() {
        val input = """
            acc +1
            jmp -1
        """.trimIndent()

        assertEquals(1, runUntilLoop(input))
    }

    @Test
    fun `handle loops with acc -1, jmp -1`() {
        val input = """
            acc -1
            jmp -1
        """.trimIndent()

        assertEquals(-1, runUntilLoop(input))
    }

    @Test
    fun `handle loops with nop`() {
        val input = """
            nop +99
            jmp -1
        """.trimIndent()

        assertEquals(0, runUntilLoop(input))
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

        assertEquals(5, runUntilLoop(input))
    }

    @Test
    fun `run program that does not need to be fixed`() {
        val input = "acc +1"

        assertEquals(1, runProgram(input))
    }

    @Test
    fun `fix program by replacing jmp with nop`() {
        val input = "jmp 0"

        assertEquals(0, runProgram(input))
    }

    @Test
    fun `fix program by replacing jmp with nop, incrementing the accumulator`() {
        val input = """
            acc +1
            jmp -1
            acc +1
        """.trimIndent()

        assertEquals(2, runProgram(input))
    }

    @Test
    fun `fix program by replacing jmp with nop, decrementing the accumulator`() {
        val input = """
            acc -1
            jmp -1
        """.trimIndent()

        assertEquals(-1, runProgram(input))
    }

    @Test
    fun `fix program by replacing only the first nop with jmp`() {
        val input = """
            nop +1
            nop -1
        """.trimIndent()

        assertEquals(0, runProgram(input))
    }

    @Test
    fun `fix program by replacing only the second nop with jmp`() {
        val input = """
            nop +0
            nop +1
        """.trimIndent()

        assertEquals(0, runProgram(input))
    }

    @Test
    fun `accumulator is 8 after the fixed program ends`() {
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

        assertEquals(8, runProgram(input))
    }
}