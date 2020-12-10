package com.goblindegook.adventofcode2020

fun main() {
    val input = object {}.javaClass.getResource("/day01-input.txt").readText()
    val expenseReport = input.lines().map(String::toInt)
    println(product2(expenseReport))
    println(product3(expenseReport))
}

fun product2(report: List<Int>): Int? = report
    .flatMap { first -> report.map { second -> arrayOf(first, second) } }
    .find { it.sum() == 2020 }
    ?.reduce(Int::times)

fun product3(report: List<Int>): Int? = report
    .flatMap { first -> report.flatMap { second -> report.map { third -> arrayOf(first, second, third) } } }
    .find { it.sum() == 2020 }
    ?.reduce(Int::times)
