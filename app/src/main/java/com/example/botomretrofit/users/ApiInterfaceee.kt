package com.example.botomretrofit.users

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterfaceee {


    @GET("/users")
    fun getUsers(): Call<List<DataUsers>>
}

