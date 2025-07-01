package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.DynamischeDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface DynamischeRepositoryInterface {

    suspend fun getDynamische(): DynamischeDeckungInfo
}

class DynamischeRepositoryImpl(
    private val apiService: APIService
) : DynamischeRepositoryInterface {

    override suspend fun getDynamische(): DynamischeDeckungInfo {
        return try {
            apiService.getDynamische()
        } catch (e: Exception) {
            Log.e("DynamischeRepository", "Error fetching dynamische: ${e.message}")
            DynamischeDeckungInfo()
        }
    }
}