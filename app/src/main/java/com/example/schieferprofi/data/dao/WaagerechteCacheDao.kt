package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.WaagerechteCacheEntity

@Dao
interface WaagerechteCacheDao {
    @Query("SELECT * FROM waagerechte_cache WHERE id = 'waagerechte'")
    suspend fun getCache(): WaagerechteCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: WaagerechteCacheEntity)
} 