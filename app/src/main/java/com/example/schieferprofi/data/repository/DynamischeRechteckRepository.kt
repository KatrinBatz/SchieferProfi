package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.DynamischeRechteckDoppeldeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface DynamischeRechteckRepositoryInterface {

    suspend fun getDynamischRechteck(): DynamischeRechteckDoppeldeckungInfo
}

class DynamischeRechteckRepositoryImpl(
    private val apiService: APIService
) : DynamischeRechteckRepositoryInterface {

    override suspend fun getDynamischRechteck(): DynamischeRechteckDoppeldeckungInfo {
        return try {
            apiService.getDynamischRechteck()
        } catch (e: Exception) {
            Log.e("DynamischeRechteckRepositoryImpl", "getDynamischRechteck: $e")
            DynamischeRechteckDoppeldeckungInfo()
        }
    }
}