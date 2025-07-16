package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.SchuppenCacheEntity

@Dao
interface SchuppenCacheDao {
    @Query("SELECT * FROM schuppen_cache WHERE id = 'schuppen'")
    suspend fun getCache(): SchuppenCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: SchuppenCacheEntity)
} 