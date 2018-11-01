package com.example.otavioaugusto.jsonconsumer

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.example.otavioaugusto.jsonconsumer.model.DataResponse
import com.example.otavioaugusto.jsonconsumer.model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val BASE_URL = "https://s3-sa-east-1.amazonaws.com/pontotel-docs/"
    lateinit var pDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnClique.setOnClickListener(View.OnClickListener {
            DisplayProgressDialog()
            getUsers()
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


    }


    fun getUsers() {
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var api = retrofit.create(ApiInterface::class.java)
        var call = api.getUser()

        call.enqueue(object : Callback<DataResponse> {

            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {

                if (response.isSuccessful) {
                    if (pDialog != null && pDialog!!.isShowing()) {
                        pDialog.dismiss()
                    }
                    var listOfMovies: ArrayList<User>? = response.body()?.lista
                    val adapter = Adapter(listOfMovies!!, this@MainActivity)
                    recyclerView.adapter = adapter


                }
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                if (pDialog != null && pDialog.isShowing()) {
                    pDialog.dismiss()
                }
                Log.e("ErroFailure","${t}")
            }

        })
    }

    fun DisplayProgressDialog() {

        pDialog = ProgressDialog(this@MainActivity)
        pDialog!!.setMessage("Carregando..")
        pDialog!!.setCancelable(false)
        pDialog!!.isIndeterminate = false
        pDialog!!.show()
    }
}
