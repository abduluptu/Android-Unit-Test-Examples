package com.soha.infotech.androidunittestexamples.utils

import android.content.Context
import android.content.res.AssetManager
import junit.framework.Assert
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations

/**
 * Step3: On Device Test (Instrumentation Test) -> Non UI Test (Context, AssetManager, etc.)
 *
 * Test On Device Test (Instrumentation Test)
 * as JVM Test (Local Unit Test) with the help of Mockito
 */

class QuoteManagerTest {

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var assetManager: AssetManager

    @Before
    fun setUp() {
        // Initialize mock/fake objects
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun test() {
        val testStream = QuoteManagerTest::class.java.getResourceAsStream("/quotes.json")
        // When assets property of context will be returns assetManager will be return
        // Because both(context & assetManager) will be connected
        doReturn(assetManager).`when`(context).assets
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)

        // Arrange
        val sut = QuoteManager()
        sut.populateQuoteFromAssets(context, "")
        // Act
        val quote = sut.getCurrentQuote()
        // Assert
        assertEquals("Well begun is half done.", quote.text)

    }
}