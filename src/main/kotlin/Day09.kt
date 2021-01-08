package com.goblindegook.adventofcode2020

import com.goblindegook.adventofcode2020.extension.asLongList
import com.goblindegook.adventofcode2020.input.load

fun main() {
    val data = load("/day09-input.txt")
    println(findXmasTargetValue(data, 25))
    println(findXmasWeakness(data, 25))
}

fun findXmasTargetValue(data: String, preamble: Int): Long? = data
    .asLongList()
    .windowed(preamble + 1)
    .find { it.noneIndexed { index, n -> it.drop(index + 1).any { m -> n + m == it.last() } } }
    ?.last()

fun findXmasWeakness(data: String, preamble: Int): Long? = data
    .asLongList()
    .let { findXmasTargetValue(data, preamble) to it.mapIndexed { index, _ -> it.drop(index) } }
    .let { (target, snapshots) ->
        snapshots
            .map { snapshot -> snapshot.takeWhileSum { it < target ?: 0 } }
            .find { snapshot -> snapshot.sum() == target }
    }
    ?.run { maxOrNull()?.let { minOrNull()?.plus(it) } }

private fun <T> List<T>.noneIndexed(predicate: (Int, T) -> Boolean) =
    withIndex().none { predicate(it.index, it.value) }

private fun List<Long>.takeWhileSum(predicate: (Long) -> Boolean) =
    withIndex().takeWhile { snapshot -> predicate(subList(0, snapshot.index).sum()) }.map { it.value }