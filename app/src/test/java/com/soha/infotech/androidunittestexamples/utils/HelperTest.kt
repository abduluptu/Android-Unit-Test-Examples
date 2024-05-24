package com.soha.infotech.androidunittestexamples.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

/**
 * Step2: JVM Test (Local Unit Test)
 */

class HelperTest {

    /*@Test
    fun isPalindrome() {
        // Arrange
        val helper = Helper()
        // Act
        val result = helper.isPalindrome("level")
        // Assert
        assertEquals(true, result)
    }*/

    private lateinit var helper: Helper

    @Before
    fun setup() {
        println("Before Every Test Case")
        // Arrange
        helper = Helper()
    }

    @Test
    fun isPalindrome() {
        // Act
        val result = helper.isPalindrome("hello")
        // Assert
        assertEquals(false, result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        //Act
        val result = helper.isPalindrome("level")
        //Assert
        assertEquals(true, result)
    }

    @After
    fun tearDown() {
        println("After Every Test Case")
    }
}