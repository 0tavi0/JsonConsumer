package com.example.otavioaugusto.jsonconsumer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class User (

    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("pwd") val pwd: String? = null

)
