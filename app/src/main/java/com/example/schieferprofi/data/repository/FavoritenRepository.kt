package com.example.schieferprofi.data.repository

import com.example.schieferprofi.data.dao.FavoritenDao
import com.example.schieferprofi.data.entity.FavoritenDeckart

class FavoritenRepository(private val dao: FavoritenDao) {

    suspend fun addDeckart(deckart: FavoritenDeckart) = dao.insertDeckart(deckart)

    suspend fun removeDeckart(id: String) = dao.deleteDeckart(id)

    suspend fun getAllFavoriten(): List<FavoritenDeckart> = dao.getAllDeckarten()

}