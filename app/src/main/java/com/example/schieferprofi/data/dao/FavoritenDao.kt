package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.schieferprofi.data.model.FavoritenDeckart

@Dao
interface FavoritenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeckart(deckart: FavoritenDeckart)

    @Update
    suspend fun updateDeckart(deckart: FavoritenDeckart)

    @Query("SELECT * FROM favoriten_deckart")
    suspend fun getAllDeckarten(): List<FavoritenDeckart>

    @Query("SELECT * FROM favoriten_deckart WHERE idDeckart = :id")
    suspend fun getDeckartById(id: String): FavoritenDeckart?

    @Query("DELETE FROM favoriten_deckart WHERE idDeckart = :id")
    suspend fun deleteDeckart(id: String)
}