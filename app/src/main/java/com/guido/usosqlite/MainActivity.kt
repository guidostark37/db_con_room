package com.guido.usosqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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


        binding.button.setOnClickListener {

            var name = binding.txtnombre.text.toString()
            var addres = binding.txtapellido.text.toString()
            var age:Int = binding.txtedad.text.toString().toInt()
            CoroutineScope(Dispatchers.IO).launch {

                try {
                    db.usuarioDao().insertar(UsuarioEntity(0, name, addres, age))

                    runOnUiThread { Toast.makeText(this@MainActivity,"se guardo correctamente"
                        , Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@MainActivity,mostrar_datos::class.java))}

                } catch (e: Exception) {
                    Log.e("kgao", e.message.toString())
                }
            }

        }

    }


}