package com.example.otavioaugusto.jsonconsumer.interfaces

import com.example.otavioaugusto.jsonconsumer.model.DataResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("data.json")
    fun getUser() : Call<DataResponse>

}