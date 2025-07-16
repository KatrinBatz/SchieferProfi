package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.DynamischeRechteckCacheEntity

@Dao
interface DynamischeRechteckCacheDao {
    @Query("SELECT * FROM dynamische_rechteck_cache WHERE id = 'dynamische_rechteck'")
    suspend fun getCache(): DynamischeRechteckCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: DynamischeRechteckCacheEntity)
} 