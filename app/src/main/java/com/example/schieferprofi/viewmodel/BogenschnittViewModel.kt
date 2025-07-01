package com.example.schieferprofi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.BogenschnittDeckungInfo
import com.example.schieferprofi.data.repository.BogenschnittRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BogenschnittViewModel (
    private val bogenschnittRepository: BogenschnittRepositoryInterface
) : ViewModel() {

    private val _bogenschnitt = MutableStateFlow<BogenschnittDeckungInfo>(BogenschnittDeckungInfo())

    val bogenschnitt = _bogenschnitt.asStateFlow()

    private val _isLoading = MutableStateFlow(false)

    val isLoading: StateFlow<Boolean> =_isLoading

    init {
        fetchBogenschnitt()
    }

    fun fetchBogenschnitt() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val responseBogenschnitt = bogenschnittRepository.getBogenschnitt()
                _bogenschnitt.value = responseBogenschnitt

            } catch (e: Exception) {
                Log.e("BogenschnittViewModel", "Error fetching Bogenschnitt", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}