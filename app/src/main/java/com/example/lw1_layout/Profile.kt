package com.example.lw1_layout

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("id") val id: Int,
    @SerializedName("check") val check: Float,
    @SerializedName("depth") val depth: Float): Data()