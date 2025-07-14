package com.example.schieferprofi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.repository.DeckungRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DeckungViewModel(
    private val repository: DeckungRepository
) : ViewModel() {

    private val _deckungen = MutableStateFlow<List<Deckung>>(emptyList())
    val deckungen: StateFlow<List<Deckung>> = _deckungen.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        fetchDeckungen()
    }

    private fun fetchDeckungen() {
        viewModelScope.launch {
            _isLoading.value = true
            _deckungen.value = repository
                .getAllDeckungen()
                .sortedBy { it.name }
            _isLoading.value = false
        }
    }
}