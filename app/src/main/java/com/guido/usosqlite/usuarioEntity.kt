package com.guido.usosqlite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "usuario")
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int=0,
    @ColumnInfo(name = "nombre") val nombre:String,
    @ColumnInfo(name = "apellido") val apellido:String,
    @ColumnInfo(name = "edad") val edad:Int
    )