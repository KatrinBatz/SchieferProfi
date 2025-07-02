package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.GebindesteigungInfo
import com.example.schieferprofi.data.remote.APIService

interface GebindesteigungRepositoryInterface {

    suspend fun getGebindesteigung(): GebindesteigungInfo
}

class GebindesteigungRepositoryImpl(
    private val apiService: APIService
) : GebindesteigungRepositoryInterface {

    override suspend fun getGebindesteigung(): GebindesteigungInfo {
        return try {
            apiService.getGebindesteigung()
        } catch (e: Exception) {
            Log.e("GebindesteifungsRepository", "Error fetching data: ${e.message}")
            GebindesteigungInfo()
        }
    }
}

