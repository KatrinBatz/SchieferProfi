package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.SpezialFischschuppeDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface SpezialFischschuppenRepositoryInterface {

    suspend fun getFischschuppe(): SpezialFischschuppeDeckungInfo
}

class SpezialFischschuppenRepositoryImpl(
    private val apiService: APIService
) : SpezialFischschuppenRepositoryInterface {

    override suspend fun getFischschuppe(): SpezialFischschuppeDeckungInfo {
        return try {
            apiService.getFischschuppe()
        } catch (e: Exception) {
            Log.e("SpezialFischschuppenRepository", "Error fetching data: ${e.message}")
            SpezialFischschuppeDeckungInfo()
        }
    }
}
