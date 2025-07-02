package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.WaagerechteDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface WaagerechteRepositoryInterface {

    suspend fun getWaagerecht(): WaagerechteDeckungInfo
}

class WaagerechteRepositoryImpl(
    private val apiService: APIService
) : WaagerechteRepositoryInterface {

    override suspend fun getWaagerecht(): WaagerechteDeckungInfo {
        return try {
            apiService.getWaagerecht()
        } catch (e: Exception) {
            Log.e("WaagerechteRepository", "Error fetching data: ${e.message}")
            WaagerechteDeckungInfo()
        }
    }
}
