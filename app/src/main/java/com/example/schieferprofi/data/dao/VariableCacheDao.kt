package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.VariableCacheEntity

@Dao
interface VariableCacheDao {
    @Query("SELECT * FROM variable_cache WHERE id = 'variable'")
    suspend fun getCache(): VariableCacheEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCache(cache: VariableCacheEntity)
} 