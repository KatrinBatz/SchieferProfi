package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.GebindesteigungCacheEntity

@Dao
interface GebindesteigungCacheDao {
    @Query("SELECT * FROM gebindesteigung_cache")
    suspend fun getAll(): List<GebindesteigungCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<GebindesteigungCacheEntity>)
} 