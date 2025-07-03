package com.example.schieferprofi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.DynamischeRechteckDoppeldeckungInfo
import com.example.schieferprofi.data.repository.DeckartenRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DynamischeRechteckViewModel (
    private val dynamischesRechteckRepository: DeckartenRepositoryInterface
) : ViewModel(){

    private val _dynamischeRechteck = MutableStateFlow(DynamischeRechteckDoppeldeckungInfo())

    val dynamischeRechteck = _dynamischeRechteck.asStateFlow()

    private val _isLoading = MutableStateFlow(false)

    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchDynamischeRechteck()
    }

    fun fetchDynamischeRechteck() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val responseDynamischeRechteck = dynamischesRechteckRepository.getDynamischRechteck()
            _dynamischeRechteck.value = responseDynamischeRechteck
            } catch ( e: Exception) {
                Log.e("DynamischeRechteckViewModel", "Error fetching dynamische Rechteck", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}