package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.BogenschnittDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface BogenschnittRepositoryInterface {

    suspend fun getBogenschnitt(): BogenschnittDeckungInfo
}

class BogenschnittRepositoryImpl(
    private val apiService: APIService
) : BogenschnittRepositoryInterface {

    override suspend fun getBogenschnitt(): BogenschnittDeckungInfo {
        return try {
            apiService.getBogenschnitt()
        } catch (e: Exception) {
            Log.e("BogenschnittRepository", "Error fetching Bogenschnitt", e)
            BogenschnittDeckungInfo()
        }
    }
}