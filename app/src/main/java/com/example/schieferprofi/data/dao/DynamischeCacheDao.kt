package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.DynamischeCacheEntity

@Dao
interface DynamischeCacheDao {
    @Query("SELECT * FROM dynamische_cache WHERE id = 'dynamische'")
    suspend fun getCache(): DynamischeCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: DynamischeCacheEntity)
} 