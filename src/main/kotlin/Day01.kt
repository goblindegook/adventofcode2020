package com.goblindegook.adventofcode2020

fun main() {
    val input = object {}.javaClass.getResource("/day01-input.txt").readText()
    val expenseReport = input.split("\n").map(String::toInt)
    println(product2(expenseReport))
    println(product3(expenseReport))
}

fun product2(report: List<Int>): Int? = report
    .flatMap { first -> report.map { second -> Pair(first, second) } }
    .find { it.first + it.second == 2020 }
    ?.run { first * second }

fun product3(report: List<Int>): Int? = report
    .flatMap { first -> report.flatMap { second -> report.map { third -> Triple(first, second, third) } } }
    .find { it.first + it.second + it.third == 2020 }
    ?.run { first * second * third }