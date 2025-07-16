package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.UniversalCacheEntity

@Dao
interface UniversalCacheDao {
    @Query("SELECT * FROM universal_cache WHERE id = 'universal'")
    suspend fun getCache(): UniversalCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: UniversalCacheEntity)
} 