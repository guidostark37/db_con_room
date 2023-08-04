package com.guido.usosqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.guido.usosqlite.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var db:db_usuario
             private val app = applicationContext as usuarioApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //db.getDATABASE()


        setContentView(binding.root)
        lifecycleScope.launch {
            val user = app.room.usuarioDao()
        }
    }
}