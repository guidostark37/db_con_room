package com.guido.usosqlite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guido.usosqlite.databinding.ItemUsuarioBinding

class adapter_usuario(var list: List<UsuarioEntity>): RecyclerView.Adapter<adapter_usuario.userHolder>() {

    inner class userHolder(var binding:ItemUsuarioBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userHolder {
        return userHolder(
            ItemUsuarioBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: userHolder, position: Int) {
        var user = list.get(position)
        holder.binding.txtNombre.text = user.nombre
        holder.binding.txtApellido.text = user.apellido
        holder.binding.txtEdad.text= user.edad.toString()
    }

}