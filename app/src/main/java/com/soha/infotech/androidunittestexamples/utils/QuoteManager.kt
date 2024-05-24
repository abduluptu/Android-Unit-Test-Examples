package com.soha.infotech.androidunittestexamples.utils

import android.content.Context
import com.google.gson.Gson

/**
 * Step1: On Device Test (Instrumentation Test) -> Non UI Test (Context, AssetManager, etc.)
 *
 * Step1.1: Create assets folder and past json (quotes.json) inside
 */

class QuoteManager {
    var quoteList = emptyArray<Quote>()
    var currentQuoteIndex = 0

    fun populateQuoteFromAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(json, Array<Quote>::class.java)
    }

    // Suppose We are getting data from Api, Then We can use like below function
    fun populateQuotes(quotes: Array<Quote>) {
        quoteList = quotes
    }

    // To get Current Quote
    fun getCurrentQuote(): Quote {
        return quoteList[currentQuoteIndex]
    }

    // To get Next Quote
    fun getNextQuote(): Quote {
        if (currentQuoteIndex == quoteList.size - 1) return quoteList[currentQuoteIndex]
        return quoteList[++currentQuoteIndex]
    }

    // To get Previous Quote
    fun getPreviousQuote(): Quote {
        if (currentQuoteIndex == 0) return quoteList[currentQuoteIndex]
        return quoteList[--currentQuoteIndex]
    }

}