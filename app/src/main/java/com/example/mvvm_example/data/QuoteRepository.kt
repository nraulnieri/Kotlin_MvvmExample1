package com.example.mvvm_example.data

import com.example.mvvm_example.data.network.QuoteService
import com.example.mvvm_example.model.QuoteModel
import com.example.mvvm_example.model.QuoteProvider

class QuoteRepository {
    private val api = QuoteService()
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}