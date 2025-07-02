package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.KettengebindeInfo
import com.example.schieferprofi.data.remote.APIService

interface KettengebindeRepositoryInterface {

    suspend fun getKettengebinde(): KettengebindeInfo
}

class KettengebindeRepositoryImpl(
    private val apiService: APIService
) : KettengebindeRepositoryInterface {

    override suspend fun getKettengebinde(): KettengebindeInfo {
        return try {
            apiService.getKettengebinde()
        } catch (e: Exception) {
            Log.e("AltdeutschRepository", "Error fetching data: ${e.message}")
            KettengebindeInfo()
        }
    }
}
