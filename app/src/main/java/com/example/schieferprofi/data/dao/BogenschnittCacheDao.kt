package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.BogenschnittCacheEntity

@Dao
interface BogenschnittCacheDao {
    @Query("SELECT * FROM bogenschnitt_cache WHERE id = 'bogenschnitt'")
    suspend fun getCache(): BogenschnittCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: BogenschnittCacheEntity)
} 