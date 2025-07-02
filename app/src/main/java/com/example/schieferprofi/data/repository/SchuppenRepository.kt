package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.SchuppenDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface SchuppenRepositoryInterface {

    suspend fun getSchuppen(): SchuppenDeckungInfo
}

class SchuppenRepositoryImpl(
    private val apiService: APIService
) : SchuppenRepositoryInterface {

    override suspend fun getSchuppen(): SchuppenDeckungInfo {
        return try {
            apiService.getSchuppen()
        } catch (e: Exception) {
            Log.e("SchuppenRepository", "Error fetching data: ${e.message}")
            SchuppenDeckungInfo()
        }
    }
}
