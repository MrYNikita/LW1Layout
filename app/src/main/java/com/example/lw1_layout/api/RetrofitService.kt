package com.example.lw1_layout.api

import com.example.lw1_layout.Profile
import com.example.lw1_layout.Tarif
import com.example.lw1_layout.Usluga
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitServieces {
    @GET("Tarif")
    fun getTarifsList(): Call<List<Tarif>>
    @GET("usluga")
    fun getUslugaList(): Call<List<Usluga>>
    @GET("profile/{id}")
    fun getProfile(@Path("id") id: Int): Call<Profile>
}
