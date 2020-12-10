package com.goblindegook.adventofcode2020

fun main() {
    val input = object {}.javaClass.getResource("/day06-input.txt").readText()
    println(sumAny(input))
    println(sumAll(input))
}

fun countAny(answers: String): Int = answers
    .filter(Char::isLetter)
    .toSet()
    .count()

fun countAll(answers: String): Int = answers
    .lines()
    .run { first().count { answer -> all { answer in it } } }

fun sumAny(answerGroups: String): Int = answerGroups
    .split("\n\n")
    .map(::countAny)
    .sum()

fun sumAll(answerGroups: String): Int = answerGroups
    .split("\n\n")
    .map(::countAll)
    .sum()