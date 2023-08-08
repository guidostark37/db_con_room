package com.guido.usosqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.guido.usosqlite.databinding.ActivityMostrarDatosBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class mostrar_datos : AppCompatActivity() {
    lateinit var binding: ActivityMostrarDatosBinding
    lateinit var db: db_usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = db_usuario.getDATABASE(this)
        binding.recycleUsuario.layoutManager = LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {

            try {
                var list = db.usuarioDao().mostrartodo()
                runOnUiThread {
                    binding.recycleUsuario.adapter = adapter_usuario(list)
                }

            } catch (e: Exception) {
                Log.e("kgao", e.message.toString())
            }
        }

    }
}