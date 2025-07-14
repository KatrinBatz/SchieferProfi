package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.DeckungEntity

@Dao
interface DeckungDao {

    @Query("SELECT * FROM deckung")
    suspend fun getAll(): List<DeckungEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(deckungen: List<DeckungEntity>)
}