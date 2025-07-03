package com.example.schieferprofi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.AltdeutscheDeckungInfo
import com.example.schieferprofi.data.repository.DeckartenRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AltdeutschesViewModel (
    private val altdeutschesRepository: DeckartenRepositoryInterface
) : ViewModel(){

    private val _altdeutsches = MutableStateFlow(AltdeutscheDeckungInfo())

    val altdeutsch = _altdeutsches.asStateFlow()

    private val _isLoading = MutableStateFlow(false)

    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchAltdeutsch()
    }

    fun fetchAltdeutsch() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val responseAltdeutsch = altdeutschesRepository.getAltdeutsche()
                _altdeutsches.value = responseAltdeutsch

            } catch (e: Exception) {
                Log.e("AltdeutschesViewModel", "Error fetching Altdeutsches", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}