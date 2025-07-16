package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.GezogeneCacheEntity

@Dao
interface GezogeneCacheDao {
    @Query("SELECT * FROM gezogene_cache WHERE id = 'gezogene'")
    suspend fun getCache(): GezogeneCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: GezogeneCacheEntity)
} 