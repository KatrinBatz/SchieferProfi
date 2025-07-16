package com.example.schieferprofi.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.schieferprofi.data.dao.DeckungsRegelwerkCacheDao
import com.example.schieferprofi.data.entity.DeckungsRegelwerkCacheEntity
import com.example.schieferprofi.data.model.DeckungsRegelwerk
import com.example.schieferprofi.data.remote.APIService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface DeckungsRegelwerkRepositoryInterface {
    suspend fun getDeckungsregelwerk(): List<DeckungsRegelwerk>
}

class DeckungsRegelwerkRepositoryImpl(
    private val apiService: APIService,
    private val deckungsRegelwerkCacheDao: DeckungsRegelwerkCacheDao,
    private val context: Context
) : DeckungsRegelwerkRepositoryInterface {

    private val gson = Gson()
    private val cacheTimeout = 90_000L // 90 Sekunden

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return activeNetwork.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    override suspend fun getDeckungsregelwerk(): List<DeckungsRegelwerk> {
        // Versuche zuerst aus dem Cache zu laden
        val cachedData = deckungsRegelwerkCacheDao.getAll()
        val currentTime = System.currentTimeMillis()
        
        // Prüfe ob Cache-Daten vorhanden und aktuell sind
        if (cachedData.isNotEmpty() && (currentTime - cachedData.first().lastUpdated) < cacheTimeout) {
            return try {
                val type = object : TypeToken<List<DeckungsRegelwerk>>() {}.type
                gson.fromJson(cachedData.first().jsonData, type)
            } catch (e: Exception) {
                emptyList()
            }
        }

        // Wenn keine Internetverbindung oder Cache ist aktuell, verwende Cache-Daten
        if (!isNetworkAvailable() && cachedData.isNotEmpty()) {
            return try {
                val type = object : TypeToken<List<DeckungsRegelwerk>>() {}.type
                gson.fromJson(cachedData.first().jsonData, type)
            } catch (e: Exception) {
                emptyList()
            }
        }

        // Lade von API und speichere in Cache
        return try {
            val apiData = apiService.getDeckungsregelwerk()
            val jsonData = gson.toJson(apiData)
            val cacheEntity = DeckungsRegelwerkCacheEntity(
                id = "deckungs_regelwerk",
                jsonData = jsonData,
                lastUpdated = currentTime
            )
            deckungsRegelwerkCacheDao.insertAll(listOf(cacheEntity))
            apiData
        } catch (e: Exception) {
            // Bei API-Fehler versuche Cache zu verwenden
            if (cachedData.isNotEmpty()) {
                try {
                    val type = object : TypeToken<List<DeckungsRegelwerk>>() {}.type
                    gson.fromJson(cachedData.first().jsonData, type)
                } catch (e: Exception) {
                    emptyList()
                }
            } else {
                emptyList()
            }
        }
    }
}