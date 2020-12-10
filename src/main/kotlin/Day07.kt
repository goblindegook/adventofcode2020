package com.goblindegook.adventofcode2020

// Constraints: no body blocks, no regex.

fun main() {
    val input = object {}.javaClass.getResource("/day07-input.txt").readText()
    println(countContainerTypes(input, "shiny gold"))
    println(countBags(input, "shiny gold"))
}

fun countContainerTypes(rules: String, bag: String): Int = rules
    .lines()
    .map { it.split(" bags contain ").run { get(0) to get(1) } }
    .run { containers(bag, emptySet()) }
    .count()

private fun List<Pair<String, String>>.containers(type: String, previous: Set<String>): Set<String> =
    partition { (_, contents) -> (previous + type).any { it in contents } }
        .let { (found, remaining) ->
            if (found.isEmpty()) previous
            else remaining.containers(type, previous + found.map { (container) -> container })
        }

fun countBags(rules: String, bag: String): Int = rules
    .lines()
    .recursiveCountBags(0, listOf(bag to 1)) - 1

private fun List<String>.recursiveCountBags(total: Int, queue: List<Pair<String, Int>>): Int =
    if (queue.isEmpty()) total
    else queue[0].let { (type, quantity) ->
        find { it.startsWith(type) }.orEmpty()
            .split("bags contain", ",").drop(1)
            .map(::parseContents)
            .let { contents ->
                recursiveCountBags(
                    total + quantity,
                    queue.drop(1) + contents.map { it * quantity }
                )
            }
    }

private fun parseContents(line: String): Pair<String, Int> = line
    .trim()
    .split(" ")
    .run { "${get(1)} ${get(2)}" to (get(0).toIntOrNull() ?: 0) }

private infix operator fun Pair<String, Int>.times(multiplier: Int) = first to second * multiplier