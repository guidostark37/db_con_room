package com.guido.usosqlite

import android.app.Application
import androidx.room.Room

class usuarioApp:Application() {
    val room = Room.databaseBuilder(this,db_usuario::class.java,"usuario")
        .build()
}