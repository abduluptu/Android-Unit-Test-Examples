package com.soha.infotech.androidunittestexamples.utils

/**
 * Step1:  JVM Test (Local Unit Test)
 */

class Helper {

    fun isPalindrome(input: String): Boolean {
        var i = 0
        var j = input.length - 1
        var result = true

        while (i < j) {
            if (input[i] != input[j]) {
                result = false
                break
            }
            i++
            j--
        }
        return result
    }
}