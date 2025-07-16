package com.example.schieferprofi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schieferprofi.data.entity.Gebindesteigung1CacheEntity

@Dao
interface Gebindesteigung1CacheDao {
    @Query("SELECT * FROM gebindesteigung1_cache")
    suspend fun getAll(): List<Gebindesteigung1CacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<Gebindesteigung1CacheEntity>)
} 