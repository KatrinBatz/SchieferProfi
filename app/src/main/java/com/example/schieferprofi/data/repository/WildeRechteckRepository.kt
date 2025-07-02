package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.WildeRechteckDoppeldeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface WildeRechteckRepositoryInterface {

    suspend fun getRechteck(): WildeRechteckDoppeldeckungInfo
}

class WildeRechteckRepositoryImpl(
    private val apiService: APIService
) : WildeRechteckRepositoryInterface {

    override suspend fun getRechteck(): WildeRechteckDoppeldeckungInfo {
        return try {
            apiService.getRechteck()
        } catch (e: Exception) {
            Log.e("WildeRechteckRepository", "Error fetching data: ${e.message}")
            WildeRechteckDoppeldeckungInfo()
        }
    }
}
