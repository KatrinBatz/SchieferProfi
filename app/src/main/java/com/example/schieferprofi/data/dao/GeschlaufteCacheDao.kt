package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.GeschlaufteCacheEntity

@Dao
interface GeschlaufteCacheDao {
    @Query("SELECT * FROM geschlaufte_cache WHERE id = 'geschlaufte'")
    suspend fun getCache(): GeschlaufteCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: GeschlaufteCacheEntity)
} 