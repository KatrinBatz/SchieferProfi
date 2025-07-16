package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.UnterlegteCacheEntity

@Dao
interface UnterlegteCacheDao {
    @Query("SELECT * FROM unterlegte_cache WHERE id = 'unterlegte'")
    suspend fun getCache(): UnterlegteCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: UnterlegteCacheEntity)
} 