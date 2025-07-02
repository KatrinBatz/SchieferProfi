package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.AltdeutscheDeckungInfo
import com.example.schieferprofi.data.model.VariableDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface VariableRepositoryInterface {

    suspend fun getVariable(): VariableDeckungInfo
}

class VariableRepositoryImpl(
    private val apiService: APIService
) : VariableRepositoryInterface {

    override suspend fun getVariable(): VariableDeckungInfo {
        return try {
            apiService.getVariable()
        } catch (e: Exception) {
            Log.e("VariableDeckungRepository", "Error fetching data: ${e.message}")
            VariableDeckungInfo()
        }
    }
}
