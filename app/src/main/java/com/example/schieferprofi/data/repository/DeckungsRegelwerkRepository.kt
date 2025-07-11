package com.example.schieferprofi.data.repository

import com.example.schieferprofi.data.model.DeckungsRegelwerk
import com.example.schieferprofi.data.remote.APIService

interface DeckungsRegelwerkRepositoryInterface {
    suspend fun getDeckungsregelwerk(): List<DeckungsRegelwerk>
}

class DeckungsRegelwerkRepositoryImpl(
    private val apiService: APIService
) : DeckungsRegelwerkRepositoryInterface {

    override suspend fun getDeckungsregelwerk(): List<DeckungsRegelwerk> {
        return try {
            apiService.getDeckungsregelwerk()
        } catch (e: Exception) {
            emptyList()
        }
    }
}