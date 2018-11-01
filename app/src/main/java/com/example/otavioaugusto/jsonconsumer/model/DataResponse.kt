package com.example.otavioaugusto.jsonconsumer.model

import com.google.gson.annotations.SerializedName

class DataResponse {

    @SerializedName("data")
    var lista: ArrayList<User>? = null


}