package com.goblindegook.adventofcode2020

fun main() {
    val input = object {}.javaClass.getResource("/day04-input.txt").readText()
    val passports = input.split("\n\n")
    println(completePassportCount(passports))
    println(validPassportCount(passports))
}

fun completePassportCount(passports: List<String>): Int = passports
    .map(::Passport)
    .count(Passport::isComplete)

fun validPassportCount(passports: List<String>): Int = passports
    .map(::Passport)
    .count(Passport::isValid)

data class Passport(private val passport: String) {
    private val byr = validateIntField("byr") { it in 1920..2002 }
    private val iyr = validateIntField("iyr") { it in 2010..2020 }
    private val eyr = validateIntField("eyr") { it in 2020..2030 }
    private val hgt = validateField("hgt", "(\\d+)(in|cm)") { (value, unit) ->
        when (unit) {
            "cm" -> value.toInt() in 150..193
            "in" -> value.toInt() in 59..76
            else -> false
        }
    }
    private val hcl = validateTextField("hcl", "(#[a-f0-9]{6})") { it.isNotEmpty() }
    private val ecl = validateTextField("ecl", "(\\w+)") { EYE_COLOURS.contains(it) }
    private val pid = validateTextField("pid", "(\\d+)") { it.length == 9 }

    fun isComplete(): Boolean =
        setOf("hgt", "byr", "hcl", "ecl", "iyr", "eyr", "pid")
            .all { passport.contains("${it}:") }

    fun isValid(): Boolean = byr && iyr && eyr && hgt && hcl && ecl && pid

    private fun validateField(
        field: String,
        pattern: String,
        validator: (MatchResult.Destructured) -> Boolean,
    ): Boolean =
        Regex(".*${field}:${pattern}.*", setOf(RegexOption.MULTILINE, RegexOption.DOT_MATCHES_ALL))
            .matchEntire(passport)
            ?.destructured
            ?.let(validator)
            ?: false

    private fun validateIntField(field: String, validator: (Int) -> Boolean): Boolean =
        validateField(field, "(\\d+)") { (value) -> validator(value.toInt()) }

    private fun validateTextField(field: String, pattern: String, validator: (String) -> Boolean): Boolean =
        validateField(field, pattern) { (value) -> validator(value) }

    companion object {
        private val EYE_COLOURS = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    }
}
