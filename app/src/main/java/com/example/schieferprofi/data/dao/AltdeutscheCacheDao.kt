package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.AltdeutscheCacheEntity

@Dao
interface AltdeutscheCacheDao {
    @Query("SELECT * FROM altdeutsche_cache WHERE id = 'altdeutsche'")
    suspend fun getCache(): AltdeutscheCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: AltdeutscheCacheEntity)
} 