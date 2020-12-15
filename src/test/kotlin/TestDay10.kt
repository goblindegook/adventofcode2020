package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestDay10 {
    @Test
    fun `1 difference of 1 x 1 difference of 3 = 1`() {
        val data = listOf(1)
        assertEquals(1, joltageDiffsMultiplied(data))
    }

    @Test
    fun `2 differences of 1 x 1 difference of 3 = 2`() {
        val data = listOf(1, 2)
        assertEquals(2, joltageDiffsMultiplied(data))
    }

    @Test
    fun `1 difference of 1 x 2 differences of 3 = 2`() {
        val data = listOf(1, 4)
        assertEquals(2, joltageDiffsMultiplied(data))
    }

    @Test
    fun `7 differences of 1 x 5 differences of 3 = 35`() {
        val data = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)
        assertEquals(35, joltageDiffsMultiplied(data))
    }

    @Test
    fun `22 differences of 1 x 10 differences of 3 = 220`() {
        val data = listOf(
            28,
            33,
            18,
            42,
            31,
            14,
            46,
            20,
            48,
            47,
            24,
            23,
            49,
            45,
            19,
            38,
            39,
            11,
            1,
            32,
            25,
            35,
            8,
            17,
            7,
            9,
            4,
            2,
            34,
            10,
            3
        )
        assertEquals(220, joltageDiffsMultiplied(data))
    }

    @Test
    fun `count 1 permutation of (1)`() {
        val data = listOf(1)
        assertEquals(1.toBigInteger(), adapterPermutationCount(data))
    }

    @Test
    fun `count 2 permutations of (1, 3)`() {
        val data = listOf(1, 3)
        assertEquals(2.toBigInteger(), adapterPermutationCount(data))
    }

    @Test
    fun `count 1 permutation of (2, 2)`() {
        val data = listOf(2, 2)
        assertEquals(1.toBigInteger(), adapterPermutationCount(data))
    }

    @Test
    fun `ignore order and count 2 permutations of (3, 1)`() {
        val data = listOf(1, 3)
        assertEquals(2.toBigInteger(), adapterPermutationCount(data))
    }

    @Test
    fun `count 8 permutations in the first example`() {
        val data = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)
        assertEquals(8.toBigInteger(), adapterPermutationCount(data))
    }

    @Test
    fun `count 19208 permutations in the second example`() {
        val data = listOf(
            28,
            33,
            18,
            42,
            31,
            14,
            46,
            20,
            48,
            47,
            24,
            23,
            49,
            45,
            19,
            38,
            39,
            11,
            1,
            32,
            25,
            35,
            8,
            17,
            7,
            9,
            4,
            2,
            34,
            10,
            3
        )
        assertEquals(19208.toBigInteger(), adapterPermutationCount(data))
    }
}