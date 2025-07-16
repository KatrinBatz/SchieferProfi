package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.HorizontaleCacheEntity

@Dao
interface HorizontaleCacheDao {
    @Query("SELECT * FROM horizontale_cache WHERE id = 'horizontale'")
    suspend fun getCache(): HorizontaleCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: HorizontaleCacheEntity)
} 