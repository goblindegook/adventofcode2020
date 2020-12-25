package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay13 {
    @Test
    fun `every bus departs at timestamp 0`() {
        assertEquals(1 to 0, earliestBus(0, listOf(1)))
    }

    @Test
    fun `ignore invalid buses`() {
        assertEquals(5 to 0, earliestBus(0, listOf(null, 5)))
    }

    @Test
    fun `take the bus that departs closest after the timestamp`() {
        assertEquals(7 to 4, earliestBus(10, listOf(8, 7)))
    }

    @Test
    fun `example data`() {
        assertEquals(59 to 5, earliestBus(939, listOf(7, 13, null, null, 59, null, 31, 19)))
    }
}