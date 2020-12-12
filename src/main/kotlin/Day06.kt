package com.goblindegook.adventofcode2020

fun main() {
    val input = object {}.javaClass.getResource("/day06-input.txt").readText()
    println(sumAny(input))
    println(sumAll(input))
}

fun sumAny(answerGroups: String): Int = answerGroups
    .split("\n\n")
    .map(::countAny)
    .sum()

fun countAny(answers: String): Int = answers
    .filter(Char::isLetter)
    .toSet()
    .count()

fun sumAll(answerGroups: String): Int = answerGroups
    .split("\n\n")
    .map(::countAll)
    .sum()

fun countAll(answers: String): Int = answers
    .lines()
    .run { first().count { answer -> all { answer in it } } }