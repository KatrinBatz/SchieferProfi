package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.remote.APIService

interface DeckungRepositoryInterface {
    suspend fun getDeckungen(): List<Deckung>
    suspend fun getDeckungById(id: String): Deckung
}

class DeckungRepositoryImpl(
    private val apiService: APIService
) : DeckungRepositoryInterface {

    override suspend fun getDeckungen(): List<Deckung> {
        return try {
            apiService.getDeckungen()
        } catch (e: Exception) {
            Log.e("DeckungsRepository", "Error fetching deckungen: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getDeckungById(id: String): Deckung {
        return try {
            apiService.getDeckungById(id)
        } catch (e: Exception) {
            Log.e("DeckungsRepository", "Error fetching deckungen by ID: ${e.message}")
            Deckung("", "", "", "", emptyList(), "")
        }
    }
}