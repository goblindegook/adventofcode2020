package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TestDay07 {
    @ParameterizedTest
    @ValueSource(strings = [
        "light red bags contain 1 bright white bag, 2 muted yellow bags.",
        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
        "faded blue bags contain no other bags.",
        "dotted black bags contain no other bags."
    ])
    fun `rule that a bag cannot contain shiny gold bags`(rule: String) {
        assertEquals(0, countContainerTypes(rule, "shiny gold"))
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "bright white bags contain 1 shiny gold bag.",
        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags."
    ])
    fun `rule that a bag that can contain shiny gold bags`(rule: String) {
        assertEquals(1, countContainerTypes(rule, "shiny gold"))
    }

    @Test
    fun `count bag types that can contain bags that can contain shiny gold bags`() {
        val rules ="""
            light red bags contain 1 bright white bag.
            bright white bags contain 1 shiny gold bag.
        """.trimIndent()

        assertEquals(2, countContainerTypes(rules, "shiny gold"))
    }

    @Test
    fun `count bag types that can contain shiny gold bags`() {
        val rules ="""
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
        """.trimIndent()

        assertEquals(4, countContainerTypes(rules, "shiny gold"))
    }

    @Test
    fun `count inside bags that must be empty`() {
        val rules = "shiny gold bags contain no other bags."
        assertEquals(0, countBags(rules, "shiny gold"))
    }

    @Test
    fun `count inside bags that must have one bag`() {
        val rules = """
            shiny gold bags contain 1 bright white bag.
            bright white bags contain no other bags.
        """.trimIndent()
        assertEquals(1, countBags(rules, "shiny gold"))
    }

    @Test
    fun `count inside bags that must have two bags`() {
        val rules = """
            shiny gold bags contain 2 bright white bags.
            bright white bags contain no other bags.
        """.trimIndent()
        assertEquals(2, countBags(rules, "shiny gold"))
    }

    @Test
    fun `count inside bags that must have two bags of different type`() {
        val rules = """
            shiny gold bags contain 1 bright white bag, 1 muted yellow bag.
            bright white bags contain no other bags.
            muted yellow bags contain no other bags.
        """.trimIndent()
        assertEquals(2, countBags(rules, "shiny gold"))
    }

    @Test
    fun `count inside bags that must have a bag with two other bags in it`() {
        val rules = """
            shiny gold bags contain 1 muted yellow bag.
            muted yellow bags contain 2 bright blue bags.
            bright blue bags contain no other bags.
        """.trimIndent()
        assertEquals(3, countBags(rules, "shiny gold"))
    }

    @Test
    fun `count inside bags that must have two bags each with another bag in it`() {
        val rules = """
            shiny gold bags contain 2 muted yellow bags.
            muted yellow bags contain 1 bright blue bag.
            bright blue bags contain no other bags.
        """.trimIndent()
        assertEquals(4, countBags(rules, "shiny gold"))
    }

    @Test
    fun `count inside a shiny gold bag (example 1)`() {
        val rules ="""
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
        """.trimIndent()

        assertEquals(32, countBags(rules, "shiny gold"))
    }

    @Test
    fun `count inside a shiny gold bag (example 2)`() {
        val rules ="""
            shiny gold bags contain 2 dark red bags.
            dark red bags contain 2 dark orange bags.
            dark orange bags contain 2 dark yellow bags.
            dark yellow bags contain 2 dark green bags.
            dark green bags contain 2 dark blue bags.
            dark blue bags contain 2 dark violet bags.
            dark violet bags contain no other bags.
        """.trimIndent()

        assertEquals(126, countBags(rules, "shiny gold"))
    }
}