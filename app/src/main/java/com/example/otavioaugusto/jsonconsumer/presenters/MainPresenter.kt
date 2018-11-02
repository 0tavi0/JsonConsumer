package com.example.otavioaugusto.jsonconsumer.presenters

import android.util.Log
import com.example.otavioaugusto.jsonconsumer.adapters.Adapter
import com.example.otavioaugusto.jsonconsumer.interfaces.ApiInterface
import com.example.otavioaugusto.jsonconsumer.interfaces.ListaContrato
import com.example.otavioaugusto.jsonconsumer.model.DataResponse
import com.example.otavioaugusto.jsonconsumer.model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPresenter(var view : ListaContrato.View) : ListaContrato.Presenter{



    override fun getUser() {

        view.showProgressBar()

        val BASE_URL = "https://s3-sa-east-1.amazonaws.com/pontotel-docs/"
        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            var api = retrofit.create(ApiInterface::class.java)
            var call = api.getUser()

            call.enqueue(object : Callback<DataResponse> {

                override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {

                    if (response.isSuccessful) {
                        var listOfMovies: ArrayList<User>? = response.body()?.lista


                        if (listOfMovies != null) {
                            view.mostrarUser(listOfMovies)
                        }

                        view.hideProgressBar()
                    }
                }

                override fun onFailure(call: Call<DataResponse>, t: Throwable) {

                    view.mostrarErro(t.message!!)
                }

            })
        }
}