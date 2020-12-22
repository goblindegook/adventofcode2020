package com.goblindegook.adventofcode2020

import com.goblindegook.adventofcode2020.extension.asBigIntegerList
import com.goblindegook.adventofcode2020.input.load
import java.math.BigInteger

fun main() {
    val data = load("/day09-input.txt")
    println(findXmasTargetValue(data, 25))
    println(findXmasWeakness(data, 25))
}

fun findXmasTargetValue(data: String, preamble: Int): BigInteger? = data
    .asBigIntegerList()
    .windowed(preamble + 1)
    .find { it.noneIndexed { index, n -> it.drop(index + 1).any { m -> n + m == it.last() } } }
    ?.last()

fun findXmasWeakness(data: String, preamble: Int): BigInteger? = data
    .asBigIntegerList()
    .let { findXmasTargetValue(data, preamble) to it.mapIndexed { index, _ -> it.drop(index) } }
    .let { (target, snapshots) ->
        snapshots
            .map { snapshot -> snapshot.takeWhileSum { it < target } }
            .find { snapshot -> snapshot.sumOf { it } == target }
    }
    ?.run { maxOrNull()?.let { minOrNull()?.plus(it) } }

private fun <T> List<T>.noneIndexed(predicate: (Int, T) -> Boolean) =
    withIndex().none { predicate(it.index, it.value) }

private fun List<BigInteger>.takeWhileSum(predicate: (BigInteger) -> Boolean) =
    withIndex().takeWhile { snapshot -> predicate(subList(0, snapshot.index).sumOf { it }) }.map { it.value }