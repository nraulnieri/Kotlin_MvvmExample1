package com.example.mvvm_example.domain

import com.example.mvvm_example.data.QuoteRepository
import com.example.mvvm_example.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}