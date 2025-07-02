package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.SpitzwinkelDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface SpitzwinkelRepositoryInterface {

    suspend fun getSpitzwinkel(): SpitzwinkelDeckungInfo
}

class SpitzwinkelRepositoryImpl(
    private val apiService: APIService
) : SpitzwinkelRepositoryInterface {

    override suspend fun getSpitzwinkel(): SpitzwinkelDeckungInfo {
        return try {
            apiService.getSpitzwinkel()
        } catch (e: Exception) {
            Log.e("SpitzwinkelRepository", "Error fetching data: ${e.message}")
            SpitzwinkelDeckungInfo()
        }
    }
}
