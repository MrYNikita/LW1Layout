package com.example.lw1_layout

import com.google.gson.annotations.SerializedName

data class Usluga(
    @SerializedName("id") val id: Int,
    @SerializedName("text") val text: String,
    @SerializedName("image") val image: Int): Data()
