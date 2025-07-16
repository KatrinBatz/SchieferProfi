package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.SpezialFischschuppenCacheEntity

@Dao
interface SpezialFischschuppenCacheDao {
    @Query("SELECT * FROM spezial_fischschuppen_cache WHERE id = 'spezial_fischschuppen'")
    suspend fun getCache(): SpezialFischschuppenCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: SpezialFischschuppenCacheEntity)
} 