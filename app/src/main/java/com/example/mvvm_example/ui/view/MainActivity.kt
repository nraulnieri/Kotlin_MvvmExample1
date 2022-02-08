package com.example.mvvm_example.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvvm_example.databinding.ActivityMainBinding
import com.example.mvvm_example.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val quoteViewModel:QuoteViewModel by viewModels()
        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer{
            binding.tvAuthor.text = it.author
            binding.tvQuote.text = it.quote

        })
        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }


    }
}