package com.example.botomretrofit.posts

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterfacee {


    @GET("/photos")
    fun getPhotos(): Call<List<Post>>
}