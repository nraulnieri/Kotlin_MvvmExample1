package com.example.mvvm_example.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_example.domain.GetQuotesUseCase
import com.example.mvvm_example.domain.GetRandomQuoteUseCase
import com.example.mvvm_example.model.QuoteModel
import com.example.mvvm_example.model.QuoteProvider
import kotlinx.coroutines.launch

class QuoteViewModel:ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    var getQuotesUseCase = GetQuotesUseCase()
    val isLoading = MutableLiveData<Boolean>()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }
    }
}