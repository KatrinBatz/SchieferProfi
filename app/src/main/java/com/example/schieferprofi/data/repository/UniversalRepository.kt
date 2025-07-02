package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.UniversalDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface UniversalRepositoryInterface {

    suspend fun getUniversal(): UniversalDeckungInfo
}

class UniversalRepositoryImpl(
    private val apiService: APIService
) : UniversalRepositoryInterface {

    override suspend fun getUniversal(): UniversalDeckungInfo {
        return try {
            apiService.getUniversal()
        } catch (e: Exception) {
            Log.e("UniversalRepository", "Error fetching data: ${e.message}")
            UniversalDeckungInfo()
        }
    }
}
