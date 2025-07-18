package com.example.schieferprofi.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.DeckungsRegelwerk
import com.example.schieferprofi.data.repository.DeckungsRegelwerkRepositoryInterface
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DeckungsRegelwerkViewModel(
    private val deckungsRegelwerkRepository: DeckungsRegelwerkRepositoryInterface,
    private val context: Context
) : ViewModel() {
    private val _deckungsRegelwerk = MutableStateFlow<List<DeckungsRegelwerk>>(listOf())
    val deckungsRegelwerk = _deckungsRegelwerk.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchDeckungsRegelwerk()
        startPolling()
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return activeNetwork.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    private fun startPolling() {
        viewModelScope.launch {
            while (true) {
                delay(90_000L)
                if (isNetworkAvailable()) {
                    fetchDeckungsRegelwerk()
                }
            }
        }
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