package com.example.botomretrofit.photos


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)