package com.goblindegook.adventofcode2020

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TestDay04 {
    @Test
    fun `passports with required fields`() {
        val passport = """
            ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
            byr:1937 iyr:2017 cid:147 hgt:183cm
        """.trimIndent()

        assertEquals(1, completePassportCount(listOf(passport)))
    }

    @Test
    fun `passports missing the height field are invalid`() {
        val passport = """
            iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
            hcl:#cfa07d byr:1929
        """.trimIndent()

        assertEquals(0, completePassportCount(listOf(passport)))
    }

    @Test
    fun `passports missing the eye colour field are invalid`() {
        val passport = """
            pid:860033327 eyr:2020 hcl:#fffffd
            byr:1937 iyr:2017 cid:147 hgt:183cm
        """.trimIndent()

        assertEquals(0, completePassportCount(listOf(passport)))
    }

    @Test
    fun `passports missing the passport ID field are invalid`() {
        val passport = """
            ecl:gry eyr:2020 hcl:#fffffd
            byr:1937 iyr:2017 cid:147 hgt:183cm
        """.trimIndent()

        assertEquals(0, completePassportCount(listOf(passport)))
    }

    @Test
    fun `passports missing the expiration year field are invalid`() {
        val passport = """
            ecl:gry pid:860033327 hcl:#fffffd
            byr:1937 iyr:2017 cid:147 hgt:183cm
        """.trimIndent()

        assertEquals(0, completePassportCount(listOf(passport)))
    }

    @Test
    fun `passports missing the hair colour field are invalid`() {
        val passport = """
            ecl:gry pid:860033327 eyr:2020
            byr:1937 iyr:2017 cid:147 hgt:183cm
        """.trimIndent()

        assertEquals(0, completePassportCount(listOf(passport)))
    }

    @Test
    fun `passports missing the birth year field are invalid`() {
        val passport = """
            ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
            iyr:2017 cid:147 hgt:183cm
        """.trimIndent()

        assertEquals(0, completePassportCount(listOf(passport)))
    }

    @Test
    fun `passports missing the issue year field are invalid`() {
        val passport = """
            ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
            byr:1937 cid:147 hgt:183cm
        """.trimIndent()

        assertEquals(0, completePassportCount(listOf(passport)))
    }

    @Test
    fun `passports missing the country ID field are valid`() {
        val passport = """
            hcl:#ae17e1 iyr:2013
            eyr:2024
            ecl:brn pid:760753108 byr:1931
            hgt:179cm
        """.trimIndent()

        assertEquals(1, completePassportCount(listOf(passport)))
    }

    @Test
    fun `count passports with required fields`() {
        val passports = listOf(
            """
            ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
            byr:1937 iyr:2017 cid:147 hgt:183cm
            """,
            """
            hcl:#ae17e1 iyr:2013
            eyr:2024
            ecl:brn pid:760753108 byr:1931
            hgt:179cm
            """,
            """          
            ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
            byr:1937 cid:147 hgt:183cm
            """
        ).map(String::trimIndent)

        assertEquals(2, completePassportCount(passports))
    }

    @Test
    fun `passport is valid`() {
        val passport = """
            pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
            hcl:#623a2f
        """.trimIndent()

        assertEquals(1, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with birth year before 1920 is invalid`() {
        val passport = """
            pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1919
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with birth year after 2002 is invalid`() {
        val passport = """
            pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:2003
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with issue year before 2010 is invalid`() {
        val passport = """
            pid:087499704 hgt:74in ecl:grn iyr:2009 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with issue year after 2020 is invalid`() {
        val passport = """
            pid:087499704 hgt:74in ecl:grn iyr:2021 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with expiration year before 2020 is invalid`() {
        val passport = """
            pid:087499704 hgt:74in ecl:grn iyr:2020 eyr:2019 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with expiration year after 2030 is invalid`() {
        val passport = """
            pid:087499704 hgt:74in ecl:grn iyr:2020 eyr:2031 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with unparseable height value is invalid`() {
        val passport = """
            pid:087499704 hgt:garbage ecl:grn iyr:2020 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with height below 150cm is invalid`() {
        val passport = """
            pid:087499704 hgt:149cm ecl:grn iyr:2020 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with height above 193cm is invalid`() {
        val passport = """
            pid:087499704 hgt:194cm ecl:grn iyr:2020 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with height below 59in is invalid`() {
        val passport = """
            pid:087499704 hgt:58in ecl:grn iyr:2020 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with height above 76in is invalid`() {
        val passport = """
            pid:087499704 hgt:77in ecl:grn iyr:2020 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with non hexadecimal hair colour is invalid`() {
        val passport = """
            pid:087499704 hgt:76in ecl:grn iyr:2020 eyr:2030 byr:2000
            hcl:garbage
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with invalid eye colour is invalid`() {
        val passport = """
            pid:087499704 hgt:76in ecl:foo iyr:2020 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @ParameterizedTest
    @ValueSource(strings = ["amb", "blu", "brn", "gry", "grn", "hzl", "oth"])
    fun `passport with valid eye colour is valid`(ecl: String) {
        val passport = """
            pid:087499704 hgt:76in ecl:${ecl} iyr:2020 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(1, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with ID under 9 digits is invalid`() {
        val passport = """
            pid:12345678 hgt:76in ecl:blu iyr:2020 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }

    @Test
    fun `passport with ID over 9 digits is invalid`() {
        val passport = """
            pid:1234567890 hgt:76in ecl:brn iyr:2020 eyr:2030 byr:2000
            hcl:#623a2f
        """.trimIndent()

        assertEquals(0, validPassportCount(listOf(passport)))
    }
}
