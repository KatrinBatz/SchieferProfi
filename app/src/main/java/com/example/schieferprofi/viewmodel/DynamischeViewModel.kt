package com.example.schieferprofi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.DynamischeDeckungInfo
import com.example.schieferprofi.data.repository.DynamischeRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DynamischeViewModel(
    private val dynamischeRepository: DynamischeRepositoryInterface
) : ViewModel() {

    private val _dynamisch = MutableStateFlow<DynamischeDeckungInfo>(DynamischeDeckungInfo())

    val dynamisch = _dynamisch.asStateFlow()

    private val _isLoading = MutableStateFlow(false)

    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchDynamische()
    }

    fun fetchDynamische() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val responseDynamisch = dynamischeRepository.getDynamische()
                _dynamisch.value = responseDynamisch
            } catch (e: Exception) {
                Log.e("DynamischeViewModel", "Error fetching dynamische", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}