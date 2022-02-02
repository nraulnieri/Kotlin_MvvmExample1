package com.example.mvvm_example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_example.model.QuoteModel
import com.example.mvvm_example.model.QuoteProvider

class QuoteViewModel:ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}