package com.example.schieferprofi.viewmodel

import WabenDeckungInfo
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schieferprofi.data.model.AltdeutscheDeckungInfo
import com.example.schieferprofi.data.model.BogenschnittDeckungInfo
import com.example.schieferprofi.data.model.DynamischeDeckungInfo
import com.example.schieferprofi.data.model.DynamischeRechteckDoppeldeckungInfo
import com.example.schieferprofi.data.model.GeschlaufteDeckungInfo
import com.example.schieferprofi.data.model.GezogeneDeckungInfo
import com.example.schieferprofi.data.model.HorizontaleDeckungInfo
import com.example.schieferprofi.data.model.KettengebindeInfo
import com.example.schieferprofi.data.model.LineareDeckungInfo
import com.example.schieferprofi.data.model.RechteckDoppeldeckungInfo
import com.example.schieferprofi.data.model.SchuppenDeckungInfo
import com.example.schieferprofi.data.model.SpezialFischschuppeDeckungInfo
import com.example.schieferprofi.data.model.SpitzwinkelDeckungInfo
import com.example.schieferprofi.data.model.UniversalDeckungInfo
import com.example.schieferprofi.data.model.UnterlegteDeckungInfo
import com.example.schieferprofi.data.model.VariableDeckungInfo
import com.example.schieferprofi.data.model.WaagerechteDeckungInfo
import com.example.schieferprofi.data.model.WildeRechteckDoppeldeckungInfo
import com.example.schieferprofi.data.repository.DeckartenRepositoryInterface
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class DeckartenViewModel (
    private val deckartenRepository: DeckartenRepositoryInterface,
    private val context: Context
) : ViewModel() {

    private val _altdeutsches = MutableStateFlow(AltdeutscheDeckungInfo())
    val altdeutsch = _altdeutsches.asStateFlow()
    private val _bogenschnitt = MutableStateFlow(BogenschnittDeckungInfo())
    val bogenschnitt = _bogenschnitt.asStateFlow()
    private val _dynamische = MutableStateFlow(DynamischeDeckungInfo())
    val dynamische = _dynamische.asStateFlow()
    private val _dynamischeRechteck = MutableStateFlow(DynamischeRechteckDoppeldeckungInfo())
    val dynamischeRechteck = _dynamischeRechteck.asStateFlow()
    private val _geschlaufte = MutableStateFlow(GeschlaufteDeckungInfo())
    val geschlaufte = _geschlaufte.asStateFlow()
    private val _gezogene = MutableStateFlow(GezogeneDeckungInfo())
    val gezogene = _gezogene.asStateFlow()
    private val _horizontale = MutableStateFlow(HorizontaleDeckungInfo())
    val horizontale = _horizontale.asStateFlow()
    private val _kettengebinde = MutableStateFlow(KettengebindeInfo())
    val kettengebinde = _kettengebinde.asStateFlow()
    private val _lineare = MutableStateFlow(LineareDeckungInfo())
    val lineare = _lineare.asStateFlow()
    private val _rechteck = MutableStateFlow(RechteckDoppeldeckungInfo())
    val rechteck = _rechteck.asStateFlow()
    private val _schuppen = MutableStateFlow(SchuppenDeckungInfo())
    val schuppen = _schuppen.asStateFlow()
    private val _fischschuppe = MutableStateFlow(SpezialFischschuppeDeckungInfo())
    val fischschuppe = _fischschuppe.asStateFlow()
    private val _spitzwinkel = MutableStateFlow(SpitzwinkelDeckungInfo())
    val spitzwinkel = _spitzwinkel.asStateFlow()
    private val _universal = MutableStateFlow(UniversalDeckungInfo())
    val universal = _universal.asStateFlow()
    private val _unterlegte = MutableStateFlow(UnterlegteDeckungInfo())
    val unterlegte = _unterlegte.asStateFlow()
    private val _variable = MutableStateFlow(VariableDeckungInfo())
    val variable = _variable.asStateFlow()
    private val _waagerechte = MutableStateFlow(WaagerechteDeckungInfo())
    val waagerechte = _waagerechte.asStateFlow()
    private val _waben = MutableStateFlow(WabenDeckungInfo())
    val waben = _waben.asStateFlow()
    private val _wildeRechteck = MutableStateFlow(WildeRechteckDoppeldeckungInfo())
    val wildeRechteck = _wildeRechteck.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchDeckarten()
        startPolling()
    }

    private fun isInternetAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        
        return activeNetwork.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
               activeNetwork.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }

    private fun startPolling() {
        viewModelScope.launch {
            while (true) {
                delay(90_000)
                if (isInternetAvailable()) {
                    fetchDeckarten()
                }
            }
        }
    }

    fun fetchDeckarten() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                coroutineScope {
                    val altdeutschDeferred = async { deckartenRepository.getAltdeutsche() }
                    val bogenschnittDeferred = async { deckartenRepository.getBogenschnitt() }
                    val dynamischeRechteckDeferred =
                        async { deckartenRepository.getDynamischRechteck() }
                    val dynamischeDeferred = async { deckartenRepository.getDynamische() }
                    val geschlaufteDeferred = async { deckartenRepository.getGeschlaufte() }
                    val gezogeneDeferred = async { deckartenRepository.getGezogene() }
                    val horizontaleDeferred = async { deckartenRepository.getHorizontale() }
                    val kettengebindeDeferred = async { deckartenRepository.getKettengebinde() }
                    val lineareDeferred = async { deckartenRepository.getLineare() }
                    val rechteckDeferred = async { deckartenRepository.getRechteckDoppeldeckung() }
                    val schuppenDeferred = async { deckartenRepository.getSchuppen() }
                    val fischschuppeDeferred = async { deckartenRepository.getFischschuppe() }
                    val spitzwinkelDeferred = async { deckartenRepository.getSpitzwinkel() }
                    val universalDeferred = async { deckartenRepository.getUniversal() }
                    val unterlegteDeferred = async { deckartenRepository.getUnterlegte() }
                    val variableDeferred = async { deckartenRepository.getVariable() }
                    val waagerechteDeferred = async { deckartenRepository.getWaagerecht() }
                    val wabenDeferred = async { deckartenRepository.getWaben() }
                    val wildeRechteckDeferred = async { deckartenRepository.getRechteck() }

                    _altdeutsches.value = altdeutschDeferred.await()
                    _bogenschnitt.value = bogenschnittDeferred.await()
                    _dynamischeRechteck.value = dynamischeRechteckDeferred.await()
                    _dynamische.value = dynamischeDeferred.await()
                    _geschlaufte.value = geschlaufteDeferred.await()
                    _gezogene.value = gezogeneDeferred.await()
                    _horizontale.value = horizontaleDeferred.await()
                    _kettengebinde.value = kettengebindeDeferred.await()
                    _lineare.value = lineareDeferred.await()
                    _rechteck.value = rechteckDeferred.await()
                    _schuppen.value = schuppenDeferred.await()
                    _fischschuppe.value = fischschuppeDeferred.await()
                    _spitzwinkel.value = spitzwinkelDeferred.await()
                    _universal.value = universalDeferred.await()
                    _unterlegte.value = unterlegteDeferred.await()
                    _variable.value = variableDeferred.await()
                    _waagerechte.value = waagerechteDeferred.await()
                    _waben.value = wabenDeferred.await()
                    _wildeRechteck.value = wildeRechteckDeferred.await()
                }
            } catch (e: Exception) {
                Log.e("DeckartenViewModel", "Paralleles Laden fehlgeschlagen: ${e.message}", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}