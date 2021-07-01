package com.example.sheintask.data.remote.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiServes {

    private const val BASE_URL = "https://demo.promoclicks.net/new-qraib/public/api/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val sheinService: SheinApi = getRetrofit()
        .create(SheinApi::class.java)


}