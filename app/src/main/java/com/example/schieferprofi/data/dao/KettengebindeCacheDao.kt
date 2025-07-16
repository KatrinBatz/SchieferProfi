package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.KettengebindeCacheEntity

@Dao
interface KettengebindeCacheDao {
    @Query("SELECT * FROM kettengebinde_cache WHERE id = 'kettengebinde'")
    suspend fun getCache(): KettengebindeCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: KettengebindeCacheEntity)
} 