package com.example.otavioaugusto.jsonconsumer.views

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.otavioaugusto.jsonconsumer.adapters.Adapter
import com.example.otavioaugusto.jsonconsumer.R
import com.example.otavioaugusto.jsonconsumer.interfaces.ApiInterface
import com.example.otavioaugusto.jsonconsumer.interfaces.ListaContrato
import com.example.otavioaugusto.jsonconsumer.model.DataResponse
import com.example.otavioaugusto.jsonconsumer.model.User
import com.example.otavioaugusto.jsonconsumer.presenters.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), ListaContrato.View {

    lateinit var presenter : ListaContrato.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        btnClique.setOnClickListener {
            presenter.getUser()
        }
        
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }


    override fun mostrarUser(lista: ArrayList<User>) {
        val adapter = Adapter(lista, this)
        recyclerView.adapter = adapter

    }

    override fun mostrarErro(message: String) {
      Toast.makeText(this,message, Toast.LENGTH_LONG)
    }


}
