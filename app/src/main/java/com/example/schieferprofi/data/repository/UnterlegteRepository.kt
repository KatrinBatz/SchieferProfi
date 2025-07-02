package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.UnterlegteDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface UnterlegteRepositoryInterface {

    suspend fun v(): UnterlegteDeckungInfo
}

class UnterlegteRepositoryImpl(
    private val apiService: APIService
) : UnterlegteRepositoryInterface {

    override suspend fun v(): UnterlegteDeckungInfo {
        return try {
            apiService.getUnterlegte()
        } catch (e: Exception) {
            Log.e("UnterlegteRepository", "Error fetching data: ${e.message}")
            UnterlegteDeckungInfo()
        }
    }
}
