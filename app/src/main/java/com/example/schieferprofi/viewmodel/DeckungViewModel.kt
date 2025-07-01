package com.example.schieferprofi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.repository.DeckungRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DeckungViewModel(
    private val deckungRepository: DeckungRepositoryInterface
) : ViewModel() {
    private val _deckungen = MutableStateFlow<List<Deckung>>(listOf())
    val deckungen = _deckungen.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchDeckungen()
    }

    fun fetchDeckungen() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = deckungRepository.getDeckungen()
                _deckungen.value = response.sortedBy {it.name}

            } catch (e: Exception) {
                Log.e("DECKUNGEN", "Fehler beim Abrufen der Deckungen: ${e.localizedMessage}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}


