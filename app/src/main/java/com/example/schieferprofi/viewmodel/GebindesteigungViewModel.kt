package com.example.schieferprofi.viewmodel

import androidx.lifecycle.ViewModel
import com.example.schieferprofi.data.model.GebindesteigungInfo
import com.example.schieferprofi.data.repository.DeckartenRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GebindesteigungViewModel (
    private val gebindesteigungRepository: DeckartenRepositoryInterface
) : ViewModel(){

    private val _gebindesteigung = MutableStateFlow(GebindesteigungInfo())

    val gebindesteigung = _gebindesteigung.asStateFlow()

    private val _isLoading = MutableStateFlow(false)

    val isLoading: StateFlow<Boolean> = _isLoading


}
