package com.example.lw1_layout

import com.google.gson.annotations.SerializedName

data class Tarif(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Float,
    @SerializedName("speed") val speed: String): Data()
