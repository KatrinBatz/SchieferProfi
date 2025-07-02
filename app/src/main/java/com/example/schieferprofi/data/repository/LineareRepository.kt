package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.LineareDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface LineareRepositoryInterface {

    suspend fun getLineare(): LineareDeckungInfo
}

class LineareRepositoryImpl(
    private val apiService: APIService
) : LineareRepositoryInterface {

    override suspend fun getLineare(): LineareDeckungInfo {
        return try {
            apiService.getLineare()
        } catch (e: Exception) {
            Log.e("LineareRepository", "Error fetching data: ${e.message}")
            LineareDeckungInfo()
        }
    }
}
