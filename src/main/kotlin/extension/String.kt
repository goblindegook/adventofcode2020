package com.goblindegook.adventofcode2020.extension

fun String.toIntOr(value: Int): Int = toIntOrNull() ?: value

fun String.asIntList(): List<Int> = lines().map(String::toInt)

fun String.asLongList(): List<Long> = lines().map(String::toLong)