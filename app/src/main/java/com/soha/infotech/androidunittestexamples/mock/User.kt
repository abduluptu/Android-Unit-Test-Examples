package com.soha.infotech.androidunittestexamples.mock

/**
 * Step2: Mockito, Create a model class and an enum class to check login status
 */

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)


enum class LOGIN_STATUS {
    INVALID_USER,
    INVALID_PASSWORD,
    UNKNOWN_ERROR,
    SUCCESS
}