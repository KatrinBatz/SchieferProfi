package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.AltdeutscheDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface AltdeutschRepositoryInterface {

    suspend fun getAltdeutsche(): AltdeutscheDeckungInfo
}

class AltdeutschRepositoryImpl(
    private val apiService: APIService
) : AltdeutschRepositoryInterface {

    override suspend fun getAltdeutsche(): AltdeutscheDeckungInfo {
        return try {
            apiService.getAltdeutsche()
        } catch (e: Exception) {
            Log.e("AltdeutschRepository", "Error fetching data: ${e.message}")
            AltdeutscheDeckungInfo()
        }
    }
}

