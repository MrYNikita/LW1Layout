package com.example.lw1_layout.api

import com.example.lw1_layout.Profile
import com.example.lw1_layout.Tarif
import com.example.lw1_layout.Usluga
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("Tarif")
    suspend fun getTarifsList(): List<Tarif>
    @GET("usluga")
    suspend fun getUslugaList(): List<Usluga>
    @GET("profile/{id}")
    suspend fun getProfile(@Path("id") id: Int): Profile
}
