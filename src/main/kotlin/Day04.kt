package com.goblindegook.adventofcode2020

import com.goblindegook.adventofcode2020.input.load

fun main() {
    val passports = load("/day04-input.txt").split("\n\n")
    println(completePassportCount(passports))
    println(validPassportCount(passports))
}

fun completePassportCount(passports: List<String>): Int = passports
    .count { REQUIRED_FIELDS.all { field -> it.contains("${field}:") } }

private val REQUIRED_FIELDS = setOf("hgt", "byr", "hcl", "ecl", "iyr", "eyr", "pid")

fun validPassportCount(passports: List<String>): Int = passports
    .count { passport ->
        passport.hasValidIntField("byr") { it in 1920..2002 } &&
                passport.hasValidIntField("iyr") { it in 2010..2020 } &&
                passport.hasValidIntField("eyr") { it in 2020..2030 } &&
                passport.hasValidTextField("pid", "(\\d+)") { it.length == 9 } &&
                passport.hasValidTextField("ecl", "(\\w+)") { EYE_COLOURS.contains(it) } &&
                passport.hasValidTextField("hcl", "(#[a-f0-9]{6})") { it.isNotEmpty() } &&
                passport.hasValidField("hgt", "(\\d+)(in|cm)") { (value, unit) ->
                    when (unit) {
                        "cm" -> value.toInt() in 150..193
                        "in" -> value.toInt() in 59..76
                        else -> false
                    }
                }
    }

private val EYE_COLOURS = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

private fun String.hasValidField(
    field: String,
    pattern: String,
    validator: (MatchResult.Destructured) -> Boolean,
): Boolean =
    Regex(".*${field}:${pattern}.*", setOf(RegexOption.MULTILINE, RegexOption.DOT_MATCHES_ALL))
        .matchEntire(this)
        ?.destructured
        ?.let(validator)
        ?: false

private fun String.hasValidIntField(field: String, validator: (Int) -> Boolean): Boolean =
    hasValidField(field, "(\\d+)") { (value) -> validator(value.toInt()) }

private fun String.hasValidTextField(field: String, pattern: String, validator: (String) -> Boolean): Boolean =
    hasValidField(field, pattern) { (value) -> validator(value) }