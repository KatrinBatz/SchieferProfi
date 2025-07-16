package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.DeckungsRegelwerkCacheEntity

@Dao
interface DeckungsRegelwerkCacheDao {
    @Query("SELECT * FROM deckungs_regelwerk_cache")
    suspend fun getAll(): List<DeckungsRegelwerkCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<DeckungsRegelwerkCacheEntity>)
} 