package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.HorizontaleDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface HorizontaleRepositoryInterface {

    suspend fun getHorizontale(): HorizontaleDeckungInfo
}

class HorizontaleRepositoryImpl(
    private val apiService: APIService
) : HorizontaleRepositoryInterface {

    override suspend fun getHorizontale(): HorizontaleDeckungInfo {
        return try {
            apiService.getHorizontale()
        } catch (e: Exception) {
            Log.e("HorizontaleRepository", "Error fetching data: ${e.message}")
            HorizontaleDeckungInfo()
        }
    }
}
