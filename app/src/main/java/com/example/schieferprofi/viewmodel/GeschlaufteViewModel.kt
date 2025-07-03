package com.example.schieferprofi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.GeschlaufteDeckungInfo
import com.example.schieferprofi.data.repository.DeckartenRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GeschlaufteViewModel(
    private val geschlaufteRepository: DeckartenRepositoryInterface
) : ViewModel() {

    private val _geschlaufte = MutableStateFlow(GeschlaufteDeckungInfo())

    val geschlaufte = _geschlaufte.asStateFlow()

    private val _isLoading = MutableStateFlow(false)

    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchGeschlaufte()
        Log.d("DEBUG", "Fetched info: ${_geschlaufte.value}")
    }

    fun fetchGeschlaufte() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val responseGeschlaufte = geschlaufteRepository.getGeschlaufte()
                _geschlaufte.value = responseGeschlaufte

            } catch (e: Exception) {
                Log.e("GeschlaufteViewModel", "Error fetching geschlaufte: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}