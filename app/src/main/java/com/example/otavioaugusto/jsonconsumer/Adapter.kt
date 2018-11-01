package com.example.otavioaugusto.jsonconsumer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.otavioaugusto.jsonconsumer.R.id.parent
import com.example.otavioaugusto.jsonconsumer.model.User

class Adapter(val listaUsuario: ArrayList<User>, val context : Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        val ivh = ViewHolder(v)
        return ivh
    }

    override fun getItemCount(): Int {

        return listaUsuario.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.txtNome.text = listaUsuario[position].name
        holder.txtID.text = listaUsuario[position].id
        holder.txtPwd.text = listaUsuario[position].pwd


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtNome = itemView.findViewById(R.id.txtNome) as TextView
        val txtID = itemView.findViewById(R.id.txtID) as TextView
        val txtPwd = itemView.findViewById(R.id.txtPwd) as TextView



    }
}