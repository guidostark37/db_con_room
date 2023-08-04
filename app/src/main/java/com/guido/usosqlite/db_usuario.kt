package com.guido.usosqlite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UsuarioEntity::class],
    version = 1
)
abstract class db_usuario : RoomDatabase() {
    abstract fun usuarioDao(): usuarioDAO


    companion object {
        @Volatile
        private var INSTANCE: db_usuario? = null
        fun getDATABASE(context: Context): db_usuario {
            if (INSTANCE != null) {
                return INSTANCE!!
            }

            INSTANCE=Room.databaseBuilder(context.applicationContext, db_usuario::class.java, "usuario")
                .build()
            return INSTANCE!!
        }
    }
}