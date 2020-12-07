package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay01 {
    val testReport = listOf(
        1721,
        979,
        366,
        299,
        675,
        1456
    )

    @Test
    fun `multiply the two entries that add to 2020`() {
        assertEquals(514579, day01part1(testReport))
    }

    @Test
    fun `multiply the three entries that add to 2020`() {
        assertEquals(241861950, day01part2(testReport))
    }
}