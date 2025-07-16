package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.LineareCacheEntity

@Dao
interface LineareCacheDao {
    @Query("SELECT * FROM lineare_cache WHERE id = 'lineare'")
    suspend fun getCache(): LineareCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: LineareCacheEntity)
} 