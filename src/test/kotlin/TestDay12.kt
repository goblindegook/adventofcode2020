package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TestDay12 {

    @Test
    fun `distance is -1 after moving one unit north`() {
        val input = "N1"
        assertEquals(1, navigateShip(input))
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
        assertEquals(1, navigateShip(input))
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
        assertEquals(1, navigateShip(input))
    }

    @Test
    fun `distance is -1 after turning left 90 degrees twice and moving forward`() {
        val input = """
            L90
            L90
            F1
        """.trimIndent()
        assertEquals(1, navigateShip(input))
    }

    @Test
    fun `distance is -1 after turning right 90 degrees twice and moving forward`() {
        val input = """
            R90
            R90
            F1
        """.trimIndent()
        assertEquals(1, navigateShip(input))
    }

    @Test
    fun `distance is -1 after turning right 90 degrees three times and moving forward`() {
        val input = """
            R90
            R90
            R90
            F1
        """.trimIndent()
        assertEquals(1, navigateShip(input))
    }

    @Test
    fun `distance is -1 after turning right 180 degrees and moving forward`() {
        val input = """
            R180
            F1
        """.trimIndent()
        assertEquals(1, navigateShip(input))
    }

    @Test
    fun `distance is -2 after moving two units north`() {
        val input = "N2"
        assertEquals(2, navigateShip(input))
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
        assertEquals(2, navigateShip(input))
    }

    @Test
    fun `distance is 2 after moving forward two units in the initial direction`() {
        val input = "F2"
        assertEquals(2, navigateShip(input))
    }

    @Test
    fun `example instructions`() {
        val input = """
            F10
            N3
            F7
            R90
            F11
        """.trimIndent()
        assertEquals(25, navigateShip(input))
    }

    @ParameterizedTest
    @ValueSource(strings = ["N1", "S1", "E1", "W1", "L90", "R90"])
    fun `ship does not move if only the waypoint moves`(input: String) {
        assertEquals(0, navigateShipByWaypoint(input))
    }

    @Test
    fun `forward moves the ship from (0, 0) to the waypoint at (10, -1)`() {
        val input = "F1"
        assertEquals(11, navigateShipByWaypoint(input))
    }

    @Test
    fun `forward twice moves the ship from (0, 0) to (20, -2)`() {
        val input = "F2"
        assertEquals(22, navigateShipByWaypoint(input))
    }

    @Test
    fun `shifting the waypoint south two units moves the ship from (0, 0) to (10, 1)`() {
        val input = """
            S2
            F1
        """.trimIndent()
        assertEquals(11, navigateShipByWaypoint(input))
    }

    @Test
    fun `shifting the waypoint north two units moves the ship from (0, 0) to (10, -3)`() {
        val input = """
            N2
            F1
        """.trimIndent()
        assertEquals(13, navigateShipByWaypoint(input))
    }

    @Test
    fun `shifting the waypoint west two units moves the ship from (0, 0) to (8, -1)`() {
        val input = """
            W2
            F1
        """.trimIndent()
        assertEquals(9, navigateShipByWaypoint(input))
    }

    @Test
    fun `shifting the waypoint east two units moves the ship from (0, 0) to (12, -1)`() {
        val input = """
            E2
            F1
        """.trimIndent()
        assertEquals(13, navigateShipByWaypoint(input))
    }

    @Test
    fun `rotating the waypoint left 90 degrees moves the ship from (0, 0) to (-1, -10)`() {
        val input = """
            L90
            F1
        """.trimIndent()
        assertEquals(11, navigateShipByWaypoint(input))
    }

    @Test
    fun `rotating the waypoint right 90 degrees moves the ship from (0, 0) to (1, 10)`() {
        val input = """
            R90
            F1
        """.trimIndent()
        assertEquals(11, navigateShipByWaypoint(input))
    }

    @Test
    fun `rotating the waypoint left 180 degrees is the same as rotating the waypoint right 180 degrees`() {
        val left = """
            L180
            F1
        """.trimIndent()
        val right = """
            R180
            F1
        """.trimIndent()

        assertEquals(navigateShipByWaypoint(left), navigateShipByWaypoint(right))
    }

    @Test
    fun `rotating the waypoint left 270 degrees is the same as rotating the waypoint right 90 degrees`() {
        val left = """
            L270
            F1
        """.trimIndent()
        val right = """
            R90
            F1
        """.trimIndent()

        assertEquals(navigateShipByWaypoint(left), navigateShipByWaypoint(right))
    }

    @Test
    fun `example instructions using waypoint`() {
        val input = """
            F10
            N3
            F7
            R90
            F11
        """.trimIndent()
        assertEquals(286, navigateShipByWaypoint(input))
    }
}