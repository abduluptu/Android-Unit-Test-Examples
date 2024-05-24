package com.soha.infotech.androidunittestexamples.utils

/**
 * Problem Statement: Validate Password
 * - Should not be empty
 * - length should between 6 & 15
 * - Otherwise, return valid password
 *
 * Problem Statement: String Reversal
 * - "ABC" -> ""CBA
 */

class Validator {

    // validate password
    fun validatePassword(input: String) = when {
        input.isBlank() -> {
            "Password is required field"
        }

        input.length < 6 -> {
            "Length of the password should be greater than 6"
        }

        input.length < 15 -> {
            "Length of the password should be less than 15"
        }

        else -> {
            "Valid"
        }
    }

    // Reverse String
    fun reverseString(input: String): String {
        var arr = input.toCharArray()
        var i = 0
        var j = arr.size - 1
        while (i < j) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            i++
            j--
        }
        // return arr.joinToString("")
        return String(arr)
    }

}