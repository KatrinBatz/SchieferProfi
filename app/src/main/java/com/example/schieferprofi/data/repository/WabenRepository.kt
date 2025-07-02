package com.example.schieferprofi.data.repository

import WabenDeckungInfo
import android.util.Log
import com.example.schieferprofi.data.remote.APIService

interface WabenRepositoryInterface {

    suspend fun getWaben(): WabenDeckungInfo
}

class WabenRepositoryImpl(
    private val apiService: APIService
) : WabenRepositoryInterface {

    override suspend fun getWaben(): WabenDeckungInfo {
        return try {
            apiService.getWaben()
        } catch (e: Exception) {
            Log.e("WabenRepository", "Error fetching data: ${e.message}")
            WabenDeckungInfo()
        }
    }
}
