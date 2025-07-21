package com.example.schieferprofi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.entity.FavoritenDeckart
import com.example.schieferprofi.data.repository.FavoritenRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoritenViewModel(
    private val repository: FavoritenRepository
) : ViewModel() {

    private val _favoriten = MutableStateFlow<List<FavoritenDeckart>>(emptyList())
    val favoriten: StateFlow<List<FavoritenDeckart>> = _favoriten

    private val _infoMessage = MutableStateFlow<String?>(null)
    val infoMessage: StateFlow<String?> = _infoMessage.asStateFlow()

    fun ladeFavoriten() {
        viewModelScope.launch {
            _favoriten.value = repository.getAllFavoriten()
        }
    }

    fun favoritenEntfernen(id: String) {
        viewModelScope.launch {
            repository.removeDeckart(id)
            _infoMessage.value = "Favorit entfernt"
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
                _infoMessage.value = "Favorit entfernt"
            } else {
                repository.addDeckart(deckart)
                _infoMessage.value = "Favorit hinzugefügt"
            }
            ladeFavoriten()
        }
    }

    fun clearInfoMessage() {
        _infoMessage.value = null
    }
}