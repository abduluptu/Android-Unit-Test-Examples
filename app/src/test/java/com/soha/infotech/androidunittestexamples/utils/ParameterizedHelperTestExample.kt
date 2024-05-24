package com.soha.infotech.androidunittestexamples.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

/**
 * Step2.1: JVM Test (Local Unit Test)
 */

@RunWith(value = Parameterized::class)
class ParameterizedHelperTestExample(private val input: String, private val expactedValue: Boolean) {

    @Test
    fun test() {
        // Arrange
        val helper = Helper()
        // Act
        val result = helper.isPalindrome(input)
        // Assert
        assertEquals(expactedValue, result)
    }

    companion object {

        @JvmStatic // Because JUnit is a Java Framework
        @Parameters(name = "{index} : {0} is palindrome - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }
}