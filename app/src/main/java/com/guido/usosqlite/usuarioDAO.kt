package com.guido.usosqlite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface usuarioDAO {

    @Query( "SELECT * FROM usuario ORDER BY id ASC")
    suspend fun mostrartodo():List<UsuarioEntity>

     @Query("SELECT * FROM Usuario WHERE id = :id")
     suspend fun mostrar_con_id(id:Int):UsuarioEntity

    @Update()
    suspend fun actualizar(usuario: UsuarioEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(user: UsuarioEntity)

    @Delete
    suspend fun borrar(usuario: UsuarioEntity)
}