package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.RechteckCacheEntity

@Dao
interface RechteckCacheDao {
    @Query("SELECT * FROM rechteck_cache WHERE id = 'rechteck'")
    suspend fun getCache(): RechteckCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: RechteckCacheEntity)
} 