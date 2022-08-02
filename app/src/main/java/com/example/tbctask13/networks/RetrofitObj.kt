package com.example.tbctask13.networks

import com.example.tbctask13.model.Something
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object RetrofitObj {
    private const val BASE_URL = "https://run.mocky.io/"

    val builder by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun information() = builder.create(DataGetter::class.java)
}

interface DataGetter {

    @GET("v3/3588163c-a9c8-488c-af9a-534b392e7128")
     suspend fun info(): Response<Something>
}