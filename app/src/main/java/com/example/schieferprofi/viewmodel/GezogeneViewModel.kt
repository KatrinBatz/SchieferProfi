package com.example.schieferprofi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.AltdeutscheDeckungInfo
import com.example.schieferprofi.data.model.GezogeneDeckungInfo
import com.example.schieferprofi.data.repository.DeckartenRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
//
//class GezogeneViewModel (
//    private val gezogeneRepository: DeckartenRepositoryInterface
//) : ViewModel(){
//
//    private val _gezogene = MutableStateFlow(GezogeneDeckungInfo())
//
//    val gezogene = _gezogene.asStateFlow()
//
//    private val _isLoading = MutableStateFlow(false)
//
//    val isLoading: StateFlow<Boolean> = _isLoading
//
//    init {
//        fetchGezogene()
//    }
//
//    fun fetchGezogene() {
//        viewModelScope.launch {
//            _isLoading.value = true
//            try {
//                val responseAltdeutsch = gezogeneRepository.getAltdeutsche()
//                _gezogene.value = responseAltdeutsch
//
//            } catch (e: Exception) {
//                Log.e("AltdeutschesViewModel", "Error fetching Altdeutsches", e)
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }
//}