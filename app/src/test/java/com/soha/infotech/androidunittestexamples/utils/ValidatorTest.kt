package com.soha.infotech.androidunittestexamples.utils

import org.junit.Assert.*
import org.junit.Test

/**
 * Validate password
 *
 * validate string reversal
 */

class ValidatorTest {

    @Test
    fun validatePassword_blankInput_expectedRequiredField() {
        // Arrange
        val sut = Validator()  // sut -> System Under Test
        // Act
        val result = sut.validatePassword(" ")
        // Assert
        assertEquals("Password is required field", result)
    }

    @Test
    fun validatePassword_2CharLong_expectedLengthErr() {
        val sut = Validator()
        val result = sut.validatePassword(" .")
        assertEquals("Length of the password should be greater than 6", result)
    }

    @Test
    fun validatePassword_CorrectPass_expectedValid() {
        val sut = Validator()
        val result = sut.validatePassword("Pass123")
        assertEquals("Valid", result)
    }

    @Test
    fun reverseString() {
        // Arrange
        val sut = Validator()
        // Act
        val result = sut.reverseString("")
        // Assert
        assertEquals("", result)
    }

    @Test
    fun reverseString_singlechar_samechar() {
        val sut = Validator()
        val result = sut.reverseString("a")
        println(result)
        assertEquals("a", result)
    }

    @Test
    fun reverseString_validInput_ReversedInput() {
        val sut = Validator()
        val result = sut.reverseString("ABC")
        println(result)
        assertEquals("CBA", result)
    }
}