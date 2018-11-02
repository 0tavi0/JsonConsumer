package com.example.otavioaugusto.jsonconsumer.interfaces

import com.example.otavioaugusto.jsonconsumer.model.User

interface ListaContrato {

    interface View{

        fun mostrarUser(lista : ArrayList<User>)
        fun mostrarErro(message : String)
        fun showProgressBar();
        fun hideProgressBar();

    }

    interface Presenter{

        fun getUser()

    }
}