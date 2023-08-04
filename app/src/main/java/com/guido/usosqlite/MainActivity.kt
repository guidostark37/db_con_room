package com.guido.usosqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.guido.usosqlite.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var db: db_usuario


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = db_usuario.getDATABASE(this)
        var name = binding.txtnombre.text.toString()
        var addres = binding.txtapellido.text.toString()
        var age:Int = binding.txtedad.text.toString().toInt()

        binding.button.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                try {
                    db.usuarioDao().insertar(UsuarioEntity(0, name, addres, age))
                    Log.e("kgao", "Guardao")
                } catch (e: Exception) {
                    Log.e("kgao", e.message.toString())
                }
            }
        }

    }


}