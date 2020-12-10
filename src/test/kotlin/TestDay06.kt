package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay06 {
    @Test
    fun `total of any yes answers in group with only a`() {
        val groupAnswers = """
            a
        """.trimIndent()

        assertEquals(1, countAny(groupAnswers))
    }

    @Test
    fun `total of any yes answers in group with a and b`() {
        val groupAnswers = """
            a
            b
        """.trimIndent()

        assertEquals(2, countAny(groupAnswers))
    }

    @Test
    fun `total of any yes answers in group with ab and ab`() {
        val groupAnswers = """
            ab
            ab
        """.trimIndent()

        assertEquals(2, countAny(groupAnswers))
    }

    @Test
    fun `add group yes counts`() {
        val answers = """
            abc

            a
            b
            c

            ab
            ac

            a
            a
            a
            a

            b
        """.trimIndent()

        assertEquals(11, sumAny(answers))
    }

    @Test
    fun `total of all yes answers in group with only a`() {
        val groupAnswers = """
            a
        """.trimIndent()

        assertEquals(1, countAll(groupAnswers))
    }

    @Test
    fun `total of all yes answers in group with a and b`() {
        val groupAnswers = """
            a
            b
        """.trimIndent()

        assertEquals(0, countAll(groupAnswers))
    }

    @Test
    fun `total of all yes answers in group with a and ab`() {
        val groupAnswers = """
            a
            ab
        """.trimIndent()

        assertEquals(1, countAll(groupAnswers))
    }

    @Test
    fun `total of all yes answers in group with ab and ab`() {
        val groupAnswers = """
            ab
            ab
        """.trimIndent()

        assertEquals(2, countAll(groupAnswers))
    }

    @Test
    fun `add group consensus yes counts`() {
        val answers = """
            abc

            a
            b
            c

            ab
            ac

            a
            a
            a
            a

            b
        """.trimIndent()

        assertEquals(6, sumAll(answers))
    }
}