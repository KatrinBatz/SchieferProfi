package com.example.schieferprofi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.FavoritenDeckart
import com.example.schieferprofi.data.repository.FavoritenRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoritenViewModel(
    private val repository: FavoritenRepository
) : ViewModel() {

    private val _favoriten = MutableStateFlow<List<FavoritenDeckart>>(emptyList())
    val favoriten: StateFlow<List<FavoritenDeckart>> = _favoriten

    fun ladeFavoriten() {
        viewModelScope.launch {
            _favoriten.value = repository.getAllFavoriten()
        }
    }

    fun favoritenHinzufuegen(deckart: FavoritenDeckart) {
        viewModelScope.launch {
            repository.addDeckart(deckart)
            ladeFavoriten()
        }
    }

    fun favoritenEntfernen(id: String) {
        viewModelScope.launch {
            repository.removeDeckart(id)
            ladeFavoriten()
        }
    }

    fun aktualisiereDeckart(deckart: FavoritenDeckart) {
        viewModelScope.launch {
            repository.updateDeckart(deckart)
            ladeFavoriten()
        }
    }

    fun isFavorit(idDeckart: String): Boolean {
        return favoriten.value.any { it.idDeckart == idDeckart }
    }

    fun toggleFavorit(deckart: FavoritenDeckart) {
        viewModelScope.launch {
            if (isFavorit(deckart.idDeckart)) {
                repository.removeDeckart(deckart.idDeckart)
            } else {
                repository.addDeckart(deckart)
            }
            ladeFavoriten()
        }
    }
}