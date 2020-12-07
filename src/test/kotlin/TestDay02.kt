package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TestDay02 {
    @ParameterizedTest(name = "{arguments}")
    @ValueSource(strings = ["1-1 a: a", "1-3 a: abcde", "2-9 c: ccccccccc"])
    fun `valid sled rental passwords`(password: String) {
        assertTrue(isSledPasswordValid(password))
    }

    @ParameterizedTest(name = "{arguments}")
    @ValueSource(strings = ["1-1 a: b", "1-1 a: aa", "2-2 a: a", "1-3 b: cdefg"])
    fun `invalid sled rental passwords`(password: String) {
        assertFalse(isSledPasswordValid(password))
    }

    @ParameterizedTest(name = "{arguments}")
    @ValueSource(strings = ["1-2 a: ab", "1-2 a: ba", "1-3 a: abcde"])
    fun `valid Toboggan Corporate passwords`(password: String) {
        assertTrue(isTobogganPasswordValid(password))
    }

    @ParameterizedTest(name = "{arguments}")
    @ValueSource(strings = ["1-1 a: b", "1-2 a: aa", "1-3 b: cdefg", "2-9 c: ccccccccc"])
    fun `invalid Toboggan Corporate passwords`(password: String) {
        assertFalse(isTobogganPasswordValid(password))
    }
}