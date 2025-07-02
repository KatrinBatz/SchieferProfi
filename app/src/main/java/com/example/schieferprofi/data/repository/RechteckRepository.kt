package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.RechteckDoppeldeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface RechteckRepositoryInterface {

    suspend fun getRechteckDoppeldeckung(): RechteckDoppeldeckungInfo
}

class RechteckRepositoryImpl(
    private val apiService: APIService
) : RechteckRepositoryInterface {

    override suspend fun getRechteckDoppeldeckung(): RechteckDoppeldeckungInfo {
        return try {
            apiService.getRechteckDoppeldeckung()
        } catch (e: Exception) {
            Log.e("RechteckRepository", "Error fetching data: ${e.message}")
            RechteckDoppeldeckungInfo()
        }
    }
}