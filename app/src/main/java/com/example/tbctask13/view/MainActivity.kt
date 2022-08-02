package com.example.tbctask13.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tbctask13.databinding.ActivityMainBinding
import com.example.tbctask13.model.Something
import com.example.tbctask13.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getInfo()

    }

    private fun getInfo(){
        lifecycleScope.launch {
            viewModel.info()
            viewModel.namgalasFlow.collect{
                setter(it)
            }
        }
    }

    private fun setter (item:Something){
        binding.textView.text = item.toString()

    }


}