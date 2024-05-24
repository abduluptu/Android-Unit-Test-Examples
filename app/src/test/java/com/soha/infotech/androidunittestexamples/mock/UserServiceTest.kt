package com.soha.infotech.androidunittestexamples.mock

import org.junit.Assert
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Step5: Mockito, Test UserService class functionality
 */

class UserServiceTest {

    // Define a mock object
    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        // Initialize fake/mock object
        MockitoAnnotations.openMocks(this)
        // Define behaviour mock object
        // For Invalid Login
        /* Mockito.`when`(userRepository.loginUser(anyString(), anyString()))
             .thenReturn(LOGIN_STATUS.INVALID_PASSWORD)*/

        // For Successful Login
        Mockito.`when`(userRepository.loginUser(anyString(), anyString()))
            .thenReturn(LOGIN_STATUS.SUCCESS)
    }

    /**
     * To Mock final class, because in kotlin all classes are final
     *
     * Steps: test directory -> create a resource folder -> create a mockito-extensions ->
     * create a file (org.mockito.plugins.MockMaker) -> add a line: mock-maker-inline
     */

    @Test
    fun testUserService() {
        // Arrange
        val sut = UserService(userRepository)
        // Act
        val status = sut.loginUser("abc@gmail.com", "111111")
        // Assert
        assertEquals("Password is invalid", status)
    }

    @Test
    fun testUserService_login_successful() {
        // Arrange
        val sut = UserService(userRepository)
        // Act
        val status = sut.loginUser("abc@gmail.com", "111111")
        // Assert
        assertEquals("Logged in successfully", status)
    }
}