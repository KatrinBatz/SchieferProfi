package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.SpitzwinkelCacheEntity

@Dao
interface SpitzwinkelCacheDao {
    @Query("SELECT * FROM spitzwinkel_cache WHERE id = 'spitzwinkel'")
    suspend fun getCache(): SpitzwinkelCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: SpitzwinkelCacheEntity)
} 