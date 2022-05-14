package com.tozzz.todoapp.room

import androidx.room.*
import com.tozzz.todoapp.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumGorevler(): List<Yapilacaklar>

    @Insert
    suspend fun gorevEkle(gorev: Yapilacaklar)

    @Update
    suspend fun gorevGuncelle(gorev: Yapilacaklar)

    @Delete
    suspend fun gorevSil(gorev: Yapilacaklar)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacak_is like '%'|| :aramaKelimesi || '%'")
    suspend fun gorevArama(aramaKelimesi: String): List<Yapilacaklar>
}