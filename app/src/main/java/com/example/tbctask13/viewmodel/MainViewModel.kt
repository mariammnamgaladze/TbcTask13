package com.example.tbctask13.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbctask13.model.Something
import com.example.tbctask13.networks.RetrofitObj
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _namgalasFlow = MutableSharedFlow<Something>()
    val namgalasFlow: SharedFlow<Something> get() = _namgalasFlow

        fun info (){
           viewModelScope.launch {
               val response = RetrofitObj.information().info()
               val body:Something? = response.body()
               if(response.isSuccessful && body!= null){
                    _namgalasFlow.emit(body)
                   Log.d("anichka",body.toString())
               }else{
                   Log.d("anichka",body.toString())
               }
           }
        }
}