package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay12 {

    @Test
    fun `distance is -1 after moving one unit north`() {
        val input = "N1"
        assertEquals(-1, navigateShip(input))
    }

    @Test
    fun `distance is 1 after moving one unit east`() {
        val input = "E1"
        assertEquals(1, navigateShip(input))
    }

    @Test
    fun `distance is 1 after moving one unit south`() {
        val input = "S1"
        assertEquals(1, navigateShip(input))
    }

    @Test
    fun `distance is -1 after moving one unit west`() {
        val input = "W1"
        assertEquals(-1, navigateShip(input))
    }

    @Test
    fun `distance is 1 after moving forward one unit in the initial direction`() {
        val input = "F1"
        assertEquals(1, navigateShip(input))
    }

    @Test
    fun `distance is 1 after turning right 90 degrees and moving forward`() {
        val input = """
            R90
            F1
        """.trimIndent()
        assertEquals(1, navigateShip(input))
    }

    @Test
    fun `distance is -1 after turning left 90 degrees and moving forward`() {
        val input = """
            L90
            F1
        """.trimIndent()
        assertEquals(-1, navigateShip(input))
    }

    @Test
    fun `distance is -1 after turning left 90 degrees twice and moving forward`() {
        val input = """
            L90
            L90
            F1
        """.trimIndent()
        assertEquals(-1, navigateShip(input))
    }

    @Test
    fun `distance is -1 after turning right 90 degrees twice and moving forward`() {
        val input = """
            R90
            R90
            F1
        """.trimIndent()
        assertEquals(-1, navigateShip(input))
    }

    @Test
    fun `distance is -1 after turning right 90 degrees three times and moving forward`() {
        val input = """
            R90
            R90
            R90
            F1
        """.trimIndent()
        assertEquals(-1, navigateShip(input))
    }

    @Test
    fun `distance is -1 after turning right 180 degrees and moving forward`() {
        val input = """
            R180
            F1
        """.trimIndent()
        assertEquals(-1, navigateShip(input))
    }

    @Test
    fun `distance is -2 after moving two units north`() {
        val input = "N2"
        assertEquals(-2, navigateShip(input))
    }

    @Test
    fun `distance is 2 after moving two units east`() {
        val input = "E2"
        assertEquals(2, navigateShip(input))
    }

    @Test
    fun `distance is 2 after moving two units south`() {
        val input = "S2"
        assertEquals(2, navigateShip(input))
    }

    @Test
    fun `distance is -2 after moving two units west`() {
        val input = "W2"
        assertEquals(-2, navigateShip(input))
    }

    @Test
    fun `distance is 2 after moving forward two units in the initial direction`() {
        val input = "F2"
        assertEquals(2, navigateShip(input))
    }

    @Test
    fun `example `() {
        val input = """
            F10
            N3
            F7
            R90
            F11
        """.trimIndent()
        assertEquals(25, navigateShip(input))
    }

}