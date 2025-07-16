package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.WildeCacheEntity

@Dao
interface WildeCacheDao {
    @Query("SELECT * FROM wilde_cache WHERE id = 'wilde'")
    suspend fun getCache(): WildeCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: WildeCacheEntity)
} 