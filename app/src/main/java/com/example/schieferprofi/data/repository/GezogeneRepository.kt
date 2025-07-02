package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.GezogeneDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface GezogeneRepositoryInterface {

    suspend fun getGezogene(): GezogeneDeckungInfo
}

class GezogeneRepositoryImpl(
    private val apiService: APIService
) : GezogeneRepositoryInterface {

    override suspend fun getGezogene(): GezogeneDeckungInfo {
        return try {
            apiService.getGezogene()
        } catch (e: Exception) {
            Log.e("GezogeneRepository", "Error fetching data: ${e.message}")
            GezogeneDeckungInfo()
        }
    }
}
