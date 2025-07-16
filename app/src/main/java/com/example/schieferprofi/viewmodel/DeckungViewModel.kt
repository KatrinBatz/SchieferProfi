package com.example.schieferprofi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.repository.DeckungRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class DeckungViewModel(
    private val repository: DeckungRepository,
    private val context: Context
) : ViewModel() {

    private val _deckungen = MutableStateFlow<List<Deckung>>(emptyList())
    val deckungen: StateFlow<List<Deckung>> = _deckungen.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        fetchDeckungen()
        startPolling()
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

    private fun startPolling() {
        viewModelScope.launch {
            while (true) {
                delay(90_000)
                if (hasInternetConnection()) {
                    fetchDeckungen()
                }
            }
        }
    }

    private fun hasInternetConnection(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}