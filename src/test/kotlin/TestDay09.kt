package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay09 {
    @Test
    fun `finds 4 in the sequence 1-2-4 (preamble=2)`() {
        val data = """
            1
            2
            4
        """.trimIndent()

        assertEquals(4.toBigInteger(), findXmasTargetValue(data, 2))
    }

    @Test
    fun `finds 4 in the sequence 1-2-4-3 (preamble=2)`() {
        val data = """
            1
            2
            4
            3
        """.trimIndent()

        assertEquals(4.toBigInteger(), findXmasTargetValue(data, 2))
    }

    @Test
    fun `finds 5 in the sequence 1-1-1-2-5 (preamble=3)`() {
        val data = """
            1
            1
            1
            2
            5
        """.trimIndent()

        assertEquals(5.toBigInteger(), findXmasTargetValue(data, 3))
    }

    @Test
    fun `example (preamble=5)`() {
        val data = """
            35
            20
            15
            25
            47
            40
            62
            55
            65
            95
            102
            117
            150
            182
            127
            219
            299
            277
            309
            576
        """.trimIndent()

        assertEquals(127.toBigInteger(), findXmasTargetValue(data, 5))
    }

    @Test
    fun `find weakness in example (preamble=5)`() {
        val data = """
            35
            20
            15
            25
            47
            40
            62
            55
            65
            95
            102
            117
            150
            182
            127
            219
            299
            277
            309
            576
        """.trimIndent()

        assertEquals(62.toBigInteger(), findXmasWeakness(data, 5))
    }
}