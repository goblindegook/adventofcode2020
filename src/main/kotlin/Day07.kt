package com.goblindegook.adventofcode2020

import com.goblindegook.adventofcode2020.extension.toIntOr
import com.goblindegook.adventofcode2020.input.load

fun main() {
    val rules = load("/day07-input.txt")
    println(containerTypeCount(rules, "shiny gold"))
    println(bagCount(rules, "shiny gold"))
}

fun containerTypeCount(rules: String, bag: String): Int = rules
    .lines()
    .map { rule -> rule.split(" bags contain ").let { it[0] to it[1] } }
    .containers(bag, emptySet())
    .count()

private fun List<Pair<String, String>>.containers(type: String, previous: Set<String>): Set<String> =
    partition { (_, contents) -> (previous + type).any { it in contents } }
        .let { (found, remaining) ->
            if (found.isEmpty()) previous
            else remaining.containers(type, previous + found.map { (container) -> container })
        }

fun bagCount(rules: String, bag: String): Int = rules
    .lines()
    .recursiveBagCount(0, listOf(bag to 1)) - 1

private fun List<String>.recursiveBagCount(total: Int, queue: List<Pair<String, Int>>): Int =
    if (queue.isEmpty()) total
    else queue[0].let { (type, quantity) ->
        find { it.startsWith(type) }.orEmpty()
            .split("bags contain", ",").drop(1)
            .map(::parseContents)
            .let { contents ->
                recursiveBagCount(
                    total + quantity,
                    queue.drop(1) + contents.map { it.first to it.second * quantity }
                )
            }
    }

private fun parseContents(line: String): Pair<String, Int> = line
    .trim()
    .split(" ")
    .let { "${it[1]} ${it[2]}" to (it[0].toIntOr(0)) }