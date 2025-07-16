package com.example.schieferprofi.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.Gebindesteigung1Info
import com.example.schieferprofi.data.model.GebindesteigungInfo
import com.example.schieferprofi.data.repository.GebindesteigungRepositoryInterface
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GebindesteigungViewModel(
    private val gebindesteigungRepository: GebindesteigungRepositoryInterface,
    private val context: Context
) : ViewModel() {

    private val _gebindesteigung = MutableStateFlow(GebindesteigungInfo())
    val gebindesteigung: StateFlow<GebindesteigungInfo> = _gebindesteigung.asStateFlow()

    private val _gebindesteigung1 = MutableStateFlow(
        Gebindesteigung1Info(bildUrl = "", tabelle = emptyList())
    )
    val gebindesteigung1: StateFlow<Gebindesteigung1Info> = _gebindesteigung1.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        fetchBeideGebindesteigungen()
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
                delay(90_000L) // 90 Sekunden
                if (isNetworkAvailable()) {
                    fetchBeideGebindesteigungen()
                }
            }
        }
    }

    private fun fetchBeideGebindesteigungen() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val gebindesteigung = gebindesteigungRepository.getGebindesteigung()
                val gebindesteigung1 = gebindesteigungRepository.getGebindesteigung1()

                _gebindesteigung.value = gebindesteigung
                _gebindesteigung1.value = gebindesteigung1

            } catch (e: Exception) {
                Log.e("GEBINDESTEIGUNG", "Fehler beim Laden: ${e.localizedMessage}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}