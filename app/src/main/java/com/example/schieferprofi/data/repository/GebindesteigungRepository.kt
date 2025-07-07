package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.Gebindesteigung1Info
import com.example.schieferprofi.data.model.GebindesteigungInfo
import com.example.schieferprofi.data.remote.APIService

interface GebindesteigungRepositoryInterface {
    suspend fun getGebindesteigung(): GebindesteigungInfo
    suspend fun getGebindesteigung1(): Gebindesteigung1Info
}

class GebindesteigungRepositoryImpl(
    private val apiService: APIService
) : GebindesteigungRepositoryInterface {

    override suspend fun getGebindesteigung(): GebindesteigungInfo {
        return try {
            apiService.getGebindesteigung()
        } catch (e: Exception) {
            Log.e("GEBINDESTEIGUNG", "Error fetching gebindeteigung: ${e.message}")
            GebindesteigungInfo()
        }
    }

    override suspend fun getGebindesteigung1(): Gebindesteigung1Info {
        return try {
            apiService.getGebindesteigung1()
        } catch (e: Exception) {
            Log.e("GEBINDESTEIGUNG", "Error fetching gebindeteigung1: ${e.message}")
            Gebindesteigung1Info(
                bildUrl = "",
                emptyList()
            )
        }
    }
}