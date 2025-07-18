package com.example.schieferprofi.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.example.schieferprofi.data.dao.Gebindesteigung1CacheDao
import com.example.schieferprofi.data.dao.GebindesteigungCacheDao
import com.example.schieferprofi.data.entity.Gebindesteigung1CacheEntity
import com.example.schieferprofi.data.entity.GebindesteigungCacheEntity
import com.example.schieferprofi.data.model.Gebindesteigung1Info
import com.example.schieferprofi.data.model.GebindesteigungInfo
import com.example.schieferprofi.data.remote.APIService
import com.google.gson.Gson

interface GebindesteigungRepositoryInterface {
    suspend fun getGebindesteigung(): GebindesteigungInfo
    suspend fun getGebindesteigung1(): Gebindesteigung1Info
}

class GebindesteigungRepositoryImpl(
    private val apiService: APIService,
    private val gebindesteigungCacheDao: GebindesteigungCacheDao,
    private val gebindesteigung1CacheDao: Gebindesteigung1CacheDao,
    private val context: Context
) : GebindesteigungRepositoryInterface {

    private val gson = Gson()
    private val cacheTimeout = 90_000L

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return activeNetwork.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    override suspend fun getGebindesteigung(): GebindesteigungInfo {
        val cachedData = gebindesteigungCacheDao.getAll()
        val currentTime = System.currentTimeMillis()
        
        if (cachedData.isNotEmpty() && (currentTime - cachedData.first().lastUpdated) < cacheTimeout) {
            return try {
                gson.fromJson(cachedData.first().jsonData, GebindesteigungInfo::class.java)
            } catch (e: Exception) {
                GebindesteigungInfo()
            }
        }

        if (!isNetworkAvailable() && cachedData.isNotEmpty()) {
            return try {
                gson.fromJson(cachedData.first().jsonData, GebindesteigungInfo::class.java)
            } catch (e: Exception) {
                GebindesteigungInfo()
            }
        }

        return try {
            val apiData = apiService.getGebindesteigung()
            val jsonData = gson.toJson(apiData)
            val cacheEntity = GebindesteigungCacheEntity(
                id = "gebindesteigung",
                jsonData = jsonData,
                lastUpdated = currentTime
            )
            gebindesteigungCacheDao.insertAll(listOf(cacheEntity))
            apiData
        } catch (e: Exception) {
            Log.e("GEBINDESTEIGUNG", "Error fetching gebindeteigung: ${e.message}")
            if (cachedData.isNotEmpty()) {
                try {
                    gson.fromJson(cachedData.first().jsonData, GebindesteigungInfo::class.java)
                } catch (e: Exception) {
                    GebindesteigungInfo()
                }
            } else {
                GebindesteigungInfo()
            }
        }
    }

    override suspend fun getGebindesteigung1(): Gebindesteigung1Info {
        val cachedData = gebindesteigung1CacheDao.getAll()
        val currentTime = System.currentTimeMillis()
        
        if (cachedData.isNotEmpty() && (currentTime - cachedData.first().lastUpdated) < cacheTimeout) {
            return try {
                gson.fromJson(cachedData.first().jsonData, Gebindesteigung1Info::class.java)
            } catch (e: Exception) {
                Gebindesteigung1Info(bildUrl = "", tabelle = emptyList())
            }
        }

        if (!isNetworkAvailable() && cachedData.isNotEmpty()) {
            return try {
                gson.fromJson(cachedData.first().jsonData, Gebindesteigung1Info::class.java)
            } catch (e: Exception) {
                Gebindesteigung1Info(bildUrl = "", tabelle = emptyList())
            }
        }

        return try {
            val apiData = apiService.getGebindesteigung1()
            val jsonData = gson.toJson(apiData)
            val cacheEntity = Gebindesteigung1CacheEntity(
                id = "gebindesteigung1",
                jsonData = jsonData,
                lastUpdated = currentTime
            )
            gebindesteigung1CacheDao.insertAll(listOf(cacheEntity))
            apiData
        } catch (e: Exception) {
            Log.e("GEBINDESTEIGUNG", "Error fetching gebindeteigung1: ${e.message}")
            if (cachedData.isNotEmpty()) {
                try {
                    gson.fromJson(cachedData.first().jsonData, Gebindesteigung1Info::class.java)
                } catch (e: Exception) {
                    Gebindesteigung1Info(bildUrl = "", tabelle = emptyList())
                }
            } else {
                Gebindesteigung1Info(bildUrl = "", tabelle = emptyList())
            }
        }
    }
}