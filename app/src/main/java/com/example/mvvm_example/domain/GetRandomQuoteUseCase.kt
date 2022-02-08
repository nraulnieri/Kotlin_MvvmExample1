package com.example.mvvm_example.domain

import com.example.mvvm_example.model.QuoteModel
import com.example.mvvm_example.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}