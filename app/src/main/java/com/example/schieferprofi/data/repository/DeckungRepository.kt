package com.example.schieferprofi.data.repository

import android.util.Log
import com.example.schieferprofi.data.dao.DeckungDao
import com.example.schieferprofi.data.entity.DeckungEntity
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.remote.APIService

class DeckungRepository(
    private val api: APIService,
    private val dao: DeckungDao
) {
    private fun Deckung.toEntity(): DeckungEntity = DeckungEntity(
        id = id,
        name = name,
        beschreibung = beschreibung,
        bildUrl = bildUrl,
        verwendung = verwendung,
        schwierigkeitsgrad = schwierigkeitsgrad
    )

    private fun DeckungEntity.toModel(): Deckung = Deckung(
        id = id,
        name = name,
        beschreibung = beschreibung,
        bildUrl = bildUrl,
        verwendung = verwendung,
        schwierigkeitsgrad = schwierigkeitsgrad
    )
    suspend fun getAllDeckungen(): List<Deckung> {
        val cachedEntities = dao.getAll()
        val fetchedDeckungen = try {
            api.getDeckungen()
        } catch (e: Exception) {
            Log.e("DeckungRepository", "API fehlgeschlagen, verwende Cache: ${e.message}")
            return cachedEntities.map { it.toModel() }
        }

        val cachedMap = cachedEntities.associateBy { it.id }
        val updatedEntities = mutableListOf<DeckungEntity>()

        for (deckung in fetchedDeckungen) {
            val cached = cachedMap[deckung.id]
            if (cached == null || cached != deckung.toEntity()) {
                updatedEntities.add(deckung.toEntity())
            }
        }

        if (updatedEntities.isNotEmpty()) {
            dao.insertAll(updatedEntities)
            Log.d("DeckungRepository", "Cache aktualisiert: ${updatedEntities.size} Einträge geändert")
        } else {
            Log.d("DeckungRepository", "Keine Änderungen – verwende lokale Daten")
        }

        return dao.getAll().map { it.toModel() }
    }
}