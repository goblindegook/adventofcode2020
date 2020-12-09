package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay05 {
    @Test
    fun `seat FFFFFFFLLL is row 0, column 0, id 0`() {
        assertEquals(0, seatId("FFFFFFFLLL"))
    }

    @Test
    fun `seat FFFFFFFRRR is row 0, column 7, id 7`() {
        assertEquals(7, seatId("FFFFFFFRRR"))
    }

    @Test
    fun `seat BBBBBBBLLL is row 127, column 0, id 1016`() {
        assertEquals(1016, seatId("BBBBBBBLLL"))
    }

    @Test
    fun `seat BBBBBBBRRR is row 127, column 7, id 1023`() {
        assertEquals(1023, seatId("BBBBBBBRRR"))
    }

    @Test
    fun `seat FBBBBBBRRR is row 63, column 7, id 511`() {
        assertEquals(511, seatId("FBBBBBBRRR"))
    }

    @Test
    fun `seat BBBBBBFRRR is row 126, column 7, id 1015`() {
        assertEquals(1015, seatId("BBBBBBFRRR"))
    }

    @Test
    fun `seat FFFFFFFLRR is row 0, column 3, id 3`() {
        assertEquals(3, seatId("FFFFFFFLRR"))
    }

    @Test
    fun `seat FFFFFFFRRL is row 0, column 6, id 6`() {
        assertEquals(6, seatId("FFFFFFFRRL"))
    }

    @Test
    fun `seat BFFFBBFRRR is row 70, column 7, id 567`() {
        assertEquals(567, seatId("BFFFBBFRRR"))
    }

    @Test
    fun `seat FFFBBBFRRR is row 14, column 7, id 119`() {
        assertEquals(119, seatId("FFFBBBFRRR"))
    }

    @Test
    fun `seat BBFFBBFRLL is row 102, column 4, id 820`() {
        assertEquals(820, seatId("BBFFBBFRLL"))
    }

    @Test
    fun `seat FBBBFFFRLL is row 56, column 4, id 452`() {
        assertEquals(452, seatId("FBBBFFFRLL"))
    }

    @Test
    fun `find seat between FFFFFFFRLR and FFFFFFFRRR`() {
        val boardingPasses = listOf("FFFFFFFRLR", "FFFFFFFRRR")

        assertEquals(6, findEmptySeat(boardingPasses))
    }

    @Test
    fun `find seat between FFFFFFFRRR and FFFFFFFRLR`() {
        val boardingPasses = listOf("FFFFFFFRRR", "FFFFFFFRLR")

        assertEquals(6, findEmptySeat(boardingPasses))
    }
}