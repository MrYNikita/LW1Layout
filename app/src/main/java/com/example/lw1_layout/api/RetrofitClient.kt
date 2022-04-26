package com.example.lw1_layout.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofitService: RetrofitServieces
        get() = RetrofitClient.getClient().create(RetrofitServieces::class.java)

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://6266aa5a63e0f382568553d8.mockapi.io/api/lw2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}