package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.WabenCacheEntity

@Dao
interface WabenCacheDao {
    @Query("SELECT * FROM waben_cache WHERE id = 'waben'")
    suspend fun getCache(): WabenCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: WabenCacheEntity)
} 