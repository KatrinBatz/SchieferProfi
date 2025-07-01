package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.GeschlaufteDeckungInfo
import com.example.schieferprofi.data.remote.APIService

interface GeschlaufteRepositoryInterface {

    suspend fun getGeschlaufte(): GeschlaufteDeckungInfo
}

class GeschlaufteRepositoryImpl(
    private val apiService: APIService
) : GeschlaufteRepositoryInterface {

    override suspend fun getGeschlaufte(): GeschlaufteDeckungInfo {
        return try {
            apiService.getGeschlaufte()
        } catch (e: Exception) {
            Log.e("GeschlaufteRepository", "Fehler beim Laden der Daten: $e")
            GeschlaufteDeckungInfo()
        }
    }
}