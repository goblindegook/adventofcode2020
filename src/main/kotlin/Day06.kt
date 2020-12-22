package com.goblindegook.adventofcode2020

import com.goblindegook.adventofcode2020.input.load

fun main() {
    val input = load("/day06-input.txt")
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