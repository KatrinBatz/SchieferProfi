package com.example.schieferprofi.data.repository

import WabenDeckungInfo
import android.util.Log
import com.example.schieferprofi.data.model.AltdeutscheDeckungInfo
import com.example.schieferprofi.data.model.BogenschnittDeckungInfo
import com.example.schieferprofi.data.model.DynamischeDeckungInfo
import com.example.schieferprofi.data.model.DynamischeRechteckDoppeldeckungInfo
import com.example.schieferprofi.data.model.GebindesteigungInfo
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
import com.example.schieferprofi.data.remote.APIService

interface DeckartenRepositoryInterface {

    suspend fun getAltdeutsche(): AltdeutscheDeckungInfo
    suspend fun getBogenschnitt(): BogenschnittDeckungInfo
    suspend fun getDynamischRechteck(): DynamischeRechteckDoppeldeckungInfo
    suspend fun getDynamische(): DynamischeDeckungInfo
    suspend fun getGebindesteigung(): GebindesteigungInfo
    suspend fun getGeschlaufte(): GeschlaufteDeckungInfo
    suspend fun getGezogene(): GezogeneDeckungInfo
    suspend fun getHorizontale(): HorizontaleDeckungInfo
    suspend fun getKettengebinde(): KettengebindeInfo
    suspend fun getLineare(): LineareDeckungInfo
    suspend fun getRechteckDoppeldeckung(): RechteckDoppeldeckungInfo
    suspend fun getSchuppen(): SchuppenDeckungInfo
    suspend fun getFischschuppe(): SpezialFischschuppeDeckungInfo
    suspend fun getSpitzwinkel(): SpitzwinkelDeckungInfo
    suspend fun getUniversal(): UniversalDeckungInfo
    suspend fun getUnterlegte(): UnterlegteDeckungInfo
    suspend fun getVariable(): VariableDeckungInfo
    suspend fun getWaagerecht(): WaagerechteDeckungInfo
    suspend fun getWaben(): WabenDeckungInfo
    suspend fun getRechteck(): WildeRechteckDoppeldeckungInfo

}

class DeckartenRepositoryImpl(
    private val apiService: APIService
) : DeckartenRepositoryInterface {

    override suspend fun getAltdeutsche(): AltdeutscheDeckungInfo {
        return try {
            apiService.getAltdeutsche()
        } catch (e: Exception) {
            Log.e("AltdeutschRepository", "Error fetching data: ${e.message}")
            AltdeutscheDeckungInfo()
        }
    }

    override suspend fun getBogenschnitt(): BogenschnittDeckungInfo {
        return try {
            apiService.getBogenschnitt()
        } catch (e: Exception) {
            Log.e("BogenschnittRepository", "Error fetching Bogenschnitt", e)
            BogenschnittDeckungInfo()
        }
    }

    override suspend fun getDynamischRechteck(): DynamischeRechteckDoppeldeckungInfo {
        return try {
            apiService.getDynamischRechteck()
        } catch (e: Exception) {
            Log.e("DynamischeRechteckRepositoryImpl", "getDynamischRechteck: $e")
            DynamischeRechteckDoppeldeckungInfo()
        }
    }

    override suspend fun getDynamische(): DynamischeDeckungInfo {
        return try {
            apiService.getDynamische()
        } catch (e: Exception) {
            Log.e("DynamischeRepository", "Error fetching dynamische: ${e.message}")
            DynamischeDeckungInfo()
        }
    }

    override suspend fun getGebindesteigung(): GebindesteigungInfo {
        return try {
            apiService.getGebindesteigung()
        } catch (e: Exception) {
            Log.e("GebindesteifungsRepository", "Error fetching data: ${e.message}")
            GebindesteigungInfo()
        }
    }

    override suspend fun getGeschlaufte(): GeschlaufteDeckungInfo {
        return try {
            apiService.getGeschlaufte()
        } catch (e: Exception) {
            Log.e("GeschlaufteRepository", "Fehler beim Laden der Daten: $e")
            GeschlaufteDeckungInfo()
        }
    }

    override suspend fun getGezogene(): GezogeneDeckungInfo {
        return try {
            apiService.getGezogene()
        } catch (e: Exception) {
            Log.e("GezogeneRepository", "Error fetching data: ${e.message}")
            GezogeneDeckungInfo()
        }
    }

    override suspend fun getHorizontale(): HorizontaleDeckungInfo {
        return try {
            apiService.getHorizontale()
        } catch (e: Exception) {
            Log.e("HorizontaleRepository", "Error fetching data: ${e.message}")
            HorizontaleDeckungInfo()
        }
    }

    override suspend fun getKettengebinde(): KettengebindeInfo {
        return try {
            apiService.getKettengebinde()
        } catch (e: Exception) {
            Log.e("AltdeutschRepository", "Error fetching data: ${e.message}")
            KettengebindeInfo()
        }
    }

    override suspend fun getLineare(): LineareDeckungInfo {
        return try {
            apiService.getLineare()
        } catch (e: Exception) {
            Log.e("LineareRepository", "Error fetching data: ${e.message}")
            LineareDeckungInfo()
        }
    }

    override suspend fun getRechteckDoppeldeckung(): RechteckDoppeldeckungInfo {
        return try {
            apiService.getRechteckDoppeldeckung()
        } catch (e: Exception) {
            Log.e("RechteckRepository", "Error fetching data: ${e.message}")
            RechteckDoppeldeckungInfo()
        }
    }

    override suspend fun getSchuppen(): SchuppenDeckungInfo {
        return try {
            apiService.getSchuppen()
        } catch (e: Exception) {
            Log.e("SchuppenRepository", "Error fetching data: ${e.message}")
            SchuppenDeckungInfo()
        }
    }

    override suspend fun getFischschuppe(): SpezialFischschuppeDeckungInfo {
        return try {
            apiService.getFischschuppe()
        } catch (e: Exception) {
            Log.e("SpezialFischschuppenRepository", "Error fetching data: ${e.message}")
            SpezialFischschuppeDeckungInfo()
        }
    }

    override suspend fun getSpitzwinkel(): SpitzwinkelDeckungInfo {
        return try {
            apiService.getSpitzwinkel()
        } catch (e: Exception) {
            Log.e("SpitzwinkelRepository", "Error fetching data: ${e.message}")
            SpitzwinkelDeckungInfo()
        }
    }

    override suspend fun getUniversal(): UniversalDeckungInfo {
        return try {
            apiService.getUniversal()
        } catch (e: Exception) {
            Log.e("UniversalRepository", "Error fetching data: ${e.message}")
            UniversalDeckungInfo()
        }
    }

    override suspend fun getUnterlegte(): UnterlegteDeckungInfo {
        return try {
            apiService.getUnterlegte()
        } catch (e: Exception) {
            Log.e("UnterlegteRepository", "Error fetching data: ${e.message}")
            UnterlegteDeckungInfo()
        }
    }

    override suspend fun getVariable(): VariableDeckungInfo {
        return try {
            apiService.getVariable()
        } catch (e: Exception) {
            Log.e("VariableDeckungRepository", "Error fetching data: ${e.message}")
            VariableDeckungInfo()
        }
    }

    override suspend fun getWaagerecht(): WaagerechteDeckungInfo {
        return try {
            apiService.getWaagerecht()
        } catch (e: Exception) {
            Log.e("WaagerechteRepository", "Error fetching data: ${e.message}")
            WaagerechteDeckungInfo()
        }
    }

    override suspend fun getWaben(): WabenDeckungInfo {
        return try {
            apiService.getWaben()
        } catch (e: Exception) {
            Log.e("WabenRepository", "Error fetching data: ${e.message}")
            WabenDeckungInfo()
        }
    }

    override suspend fun getRechteck(): WildeRechteckDoppeldeckungInfo {
        return try {
            apiService.getRechteck()
        } catch (e: Exception) {
            Log.e("WildeRechteckRepository", "Error fetching data: ${e.message}")
            WildeRechteckDoppeldeckungInfo()
        }
    }

}