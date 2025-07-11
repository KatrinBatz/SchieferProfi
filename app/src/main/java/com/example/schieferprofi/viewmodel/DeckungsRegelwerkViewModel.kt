package com.example.schieferprofi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.DeckungsRegelwerk
import com.example.schieferprofi.data.repository.DeckungsRegelwerkRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DeckungsRegelwerkViewModel(
    private val deckungsRegelwerkRepository: DeckungsRegelwerkRepositoryInterface
) : ViewModel() {
    private val _deckungsRegelwerk = MutableStateFlow<List<DeckungsRegelwerk>>(listOf())
    val deckungsRegelwerk = _deckungsRegelwerk.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchDeckungsRegelwerk()
    }

    fun fetchDeckungsRegelwerk(){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = deckungsRegelwerkRepository.getDeckungsregelwerk()
                _deckungsRegelwerk.value = response
            } catch (e: Exception) {
                Log.e("DeckungsRegelwerkViewModel", "Fehler beim Abrufen der DeckungsRegelwerk: ${e.localizedMessage}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}