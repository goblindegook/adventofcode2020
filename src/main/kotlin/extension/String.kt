package com.goblindegook.adventofcode2020.extension

import java.math.BigInteger

fun String.toIntOr(value: Int): Int = toIntOrNull() ?: value

fun String.asIntList(): List<Int> = lines().map(String::toInt)

fun String.asBigIntegerList(): List<BigInteger> = lines().map(String::toBigInteger)