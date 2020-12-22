package com.goblindegook.adventofcode2020

import com.goblindegook.adventofcode2020.extension.asIntList
import com.goblindegook.adventofcode2020.input.load

fun main() {
    val expenseReport = load("/day01-input.txt").asIntList()
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