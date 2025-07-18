package com.example.schieferprofi.data.repository

import WabenDeckungInfo
import android.util.Log
import com.example.schieferprofi.data.dao.AltdeutscheCacheDao
import com.example.schieferprofi.data.dao.BogenschnittCacheDao
import com.example.schieferprofi.data.dao.DynamischeCacheDao
import com.example.schieferprofi.data.dao.DynamischeRechteckCacheDao
import com.example.schieferprofi.data.dao.GeschlaufteCacheDao
import com.example.schieferprofi.data.dao.GezogeneCacheDao
import com.example.schieferprofi.data.dao.HorizontaleCacheDao
import com.example.schieferprofi.data.dao.KettengebindeCacheDao
import com.example.schieferprofi.data.dao.LineareCacheDao
import com.example.schieferprofi.data.dao.RechteckCacheDao
import com.example.schieferprofi.data.dao.SchuppenCacheDao
import com.example.schieferprofi.data.dao.SpezialFischschuppenCacheDao
import com.example.schieferprofi.data.dao.SpitzwinkelCacheDao
import com.example.schieferprofi.data.dao.UniversalCacheDao
import com.example.schieferprofi.data.dao.UnterlegteCacheDao
import com.example.schieferprofi.data.dao.VariableCacheDao
import com.example.schieferprofi.data.dao.WaagerechteCacheDao
import com.example.schieferprofi.data.dao.WabenCacheDao
import com.example.schieferprofi.data.dao.WildeCacheDao
import com.example.schieferprofi.data.entity.AltdeutscheCacheEntity
import com.example.schieferprofi.data.entity.BogenschnittCacheEntity
import com.example.schieferprofi.data.entity.DynamischeCacheEntity
import com.example.schieferprofi.data.entity.DynamischeRechteckCacheEntity
import com.example.schieferprofi.data.entity.GeschlaufteCacheEntity
import com.example.schieferprofi.data.entity.GezogeneCacheEntity
import com.example.schieferprofi.data.entity.HorizontaleCacheEntity
import com.example.schieferprofi.data.entity.KettengebindeCacheEntity
import com.example.schieferprofi.data.entity.LineareCacheEntity
import com.example.schieferprofi.data.entity.RechteckCacheEntity
import com.example.schieferprofi.data.entity.SchuppenCacheEntity
import com.example.schieferprofi.data.entity.SpezialFischschuppenCacheEntity
import com.example.schieferprofi.data.entity.SpitzwinkelCacheEntity
import com.example.schieferprofi.data.entity.UniversalCacheEntity
import com.example.schieferprofi.data.entity.UnterlegteCacheEntity
import com.example.schieferprofi.data.entity.VariableCacheEntity
import com.example.schieferprofi.data.entity.WaagerechteCacheEntity
import com.example.schieferprofi.data.entity.WabenCacheEntity
import com.example.schieferprofi.data.entity.WildeCacheEntity
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
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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
    private val apiService: APIService,
    private val altdeutscheCacheDao: AltdeutscheCacheDao,
    private val bogenschnittCacheDao: BogenschnittCacheDao,
    private val dynamischeCacheDao: DynamischeCacheDao,
    private val dynamischeRechteckCacheDao: DynamischeRechteckCacheDao,
    private val geschlaufteCacheDao: GeschlaufteCacheDao,
    private val gezogeneCacheDao: GezogeneCacheDao,
    private val horizontaleCacheDao: HorizontaleCacheDao,
    private val kettengebindeCacheDao: KettengebindeCacheDao,
    private val lineareCacheDao: LineareCacheDao,
    private val rechteckCacheDao: RechteckCacheDao,
    private val schuppenCacheDao: SchuppenCacheDao,
    private val spezialFischschuppenCacheDao: SpezialFischschuppenCacheDao,
    private val spitzwinkelCacheDao: SpitzwinkelCacheDao,
    private val universalCacheDao: UniversalCacheDao,
    private val unterlegteCacheDao: UnterlegteCacheDao,
    private val variableCacheDao: VariableCacheDao,
    private val waagerechteCacheDao: WaagerechteCacheDao,
    private val wabenCacheDao: WabenCacheDao,
    private val wildeCacheDao: WildeCacheDao
) : DeckartenRepositoryInterface {

    private val gson = Gson()
    private val cacheTimeout = 90_000L

    private fun <T> T.toJson(): String = gson.toJson(this)
    
    private inline fun <reified T> String.fromJson(): T = gson.fromJson(this, object : TypeToken<T>() {}.type)
    
    private fun isCacheValid(lastUpdated: Long): Boolean {
        return System.currentTimeMillis() - lastUpdated < cacheTimeout
    }

    override suspend fun getAltdeutsche(): AltdeutscheDeckungInfo {
        return try {
            val cachedData = altdeutscheCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<AltdeutscheDeckungInfo>()
            } else {
                val apiData = apiService.getAltdeutsche()
                val cacheEntity = AltdeutscheCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                altdeutscheCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Altdeutschen Deckung: ${e.message}", e)
            altdeutscheCacheDao.getCache()?.jsonData?.fromJson<AltdeutscheDeckungInfo>() ?: AltdeutscheDeckungInfo()
        }
    }

    override suspend fun getBogenschnitt(): BogenschnittDeckungInfo {
        return try {
            val cachedData = bogenschnittCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<BogenschnittDeckungInfo>()
            } else {
                val apiData = apiService.getBogenschnitt()
                val cacheEntity = BogenschnittCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                bogenschnittCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Bogenschnitt Deckung: ${e.message}", e)
            bogenschnittCacheDao.getCache()?.jsonData?.fromJson<BogenschnittDeckungInfo>() ?: BogenschnittDeckungInfo()
        }
    }

    override suspend fun getDynamische(): DynamischeDeckungInfo {
        return try {
            val cachedData = dynamischeCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<DynamischeDeckungInfo>()
            } else {
                val apiData = apiService.getDynamische()
                val cacheEntity = DynamischeCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                dynamischeCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Dynamischen Deckung: ${e.message}", e)
            dynamischeCacheDao.getCache()?.jsonData?.fromJson<DynamischeDeckungInfo>() ?: DynamischeDeckungInfo()
        }
    }

    override suspend fun getDynamischRechteck(): DynamischeRechteckDoppeldeckungInfo {
        return try {
            val cachedData = dynamischeRechteckCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<DynamischeRechteckDoppeldeckungInfo>()
            } else {
                val apiData = apiService.getDynamischRechteck()
                val cacheEntity = DynamischeRechteckCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                dynamischeRechteckCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Dynamischen Rechteck Deckung: ${e.message}", e)
            dynamischeRechteckCacheDao.getCache()?.jsonData?.fromJson<DynamischeRechteckDoppeldeckungInfo>() ?: DynamischeRechteckDoppeldeckungInfo()
        }
    }

    override suspend fun getGebindesteigung(): GebindesteigungInfo {
        return try {
            apiService.getGebindesteigung()
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Gebindesteigung: ${e.message}", e)
            GebindesteigungInfo()
        }
    }

    override suspend fun getGeschlaufte(): GeschlaufteDeckungInfo {
        return try {
            val cachedData = geschlaufteCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<GeschlaufteDeckungInfo>()
            } else {
                val apiData = apiService.getGeschlaufte()
                val cacheEntity = GeschlaufteCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                geschlaufteCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Geschlaufte Deckung: ${e.message}", e)
            geschlaufteCacheDao.getCache()?.jsonData?.fromJson<GeschlaufteDeckungInfo>() ?: GeschlaufteDeckungInfo()
        }
    }

    override suspend fun getGezogene(): GezogeneDeckungInfo {
        return try {
            val cachedData = gezogeneCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<GezogeneDeckungInfo>()
            } else {
                val apiData = apiService.getGezogene()
                val cacheEntity = GezogeneCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                gezogeneCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Gezogenen Deckung: ${e.message}", e)
            gezogeneCacheDao.getCache()?.jsonData?.fromJson<GezogeneDeckungInfo>() ?: GezogeneDeckungInfo()
        }
    }

    override suspend fun getHorizontale(): HorizontaleDeckungInfo {
        return try {
            val cachedData = horizontaleCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<HorizontaleDeckungInfo>()
            } else {
                val apiData = apiService.getHorizontale()
                val cacheEntity = HorizontaleCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                horizontaleCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Horizontalen Deckung: ${e.message}", e)
            horizontaleCacheDao.getCache()?.jsonData?.fromJson<HorizontaleDeckungInfo>() ?: HorizontaleDeckungInfo()
        }
    }

    override suspend fun getKettengebinde(): KettengebindeInfo {
        return try {
            val cachedData = kettengebindeCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<KettengebindeInfo>()
            } else {
                val apiData = apiService.getKettengebinde()
                val cacheEntity = KettengebindeCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                kettengebindeCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Kettengebinde: ${e.message}", e)
            kettengebindeCacheDao.getCache()?.jsonData?.fromJson<KettengebindeInfo>() ?: KettengebindeInfo()
        }
    }

    override suspend fun getLineare(): LineareDeckungInfo {
        return try {
            val cachedData = lineareCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<LineareDeckungInfo>()
            } else {
                val apiData = apiService.getLineare()
                val cacheEntity = LineareCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                lineareCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Linearen Deckung: ${e.message}", e)
            lineareCacheDao.getCache()?.jsonData?.fromJson<LineareDeckungInfo>() ?: LineareDeckungInfo()
        }
    }

    override suspend fun getRechteckDoppeldeckung(): RechteckDoppeldeckungInfo {
        return try {
            val cachedData = rechteckCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<RechteckDoppeldeckungInfo>()
            } else {
                val apiData = apiService.getRechteckDoppeldeckung()
                val cacheEntity = RechteckCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                rechteckCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Rechteck Doppeldeckung: ${e.message}", e)
            rechteckCacheDao.getCache()?.jsonData?.fromJson<RechteckDoppeldeckungInfo>() ?: RechteckDoppeldeckungInfo()
        }
    }

    override suspend fun getSchuppen(): SchuppenDeckungInfo {
        return try {
            val cachedData = schuppenCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<SchuppenDeckungInfo>()
            } else {
                val apiData = apiService.getSchuppen()
                val cacheEntity = SchuppenCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                schuppenCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Schuppen Deckung: ${e.message}", e)
            schuppenCacheDao.getCache()?.jsonData?.fromJson<SchuppenDeckungInfo>() ?: SchuppenDeckungInfo()
        }
    }

    override suspend fun getFischschuppe(): SpezialFischschuppeDeckungInfo {
        return try {
            val cachedData = spezialFischschuppenCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<SpezialFischschuppeDeckungInfo>()
            } else {
                val apiData = apiService.getFischschuppe()
                val cacheEntity = SpezialFischschuppenCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                spezialFischschuppenCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Spezial Fischschuppen Deckung: ${e.message}", e)
            spezialFischschuppenCacheDao.getCache()?.jsonData?.fromJson<SpezialFischschuppeDeckungInfo>() ?: SpezialFischschuppeDeckungInfo()
        }
    }

    override suspend fun getSpitzwinkel(): SpitzwinkelDeckungInfo {
        return try {
            val cachedData = spitzwinkelCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<SpitzwinkelDeckungInfo>()
            } else {
                val apiData = apiService.getSpitzwinkel()
                val cacheEntity = SpitzwinkelCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                spitzwinkelCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Spitzwinkel Deckung: ${e.message}", e)
            spitzwinkelCacheDao.getCache()?.jsonData?.fromJson<SpitzwinkelDeckungInfo>() ?: SpitzwinkelDeckungInfo()
        }
    }

    override suspend fun getUniversal(): UniversalDeckungInfo {
        return try {
            val cachedData = universalCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<UniversalDeckungInfo>()
            } else {
                val apiData = apiService.getUniversal()
                val cacheEntity = UniversalCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                universalCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Universal Deckung: ${e.message}", e)
            universalCacheDao.getCache()?.jsonData?.fromJson<UniversalDeckungInfo>() ?: UniversalDeckungInfo()
        }
    }

    override suspend fun getUnterlegte(): UnterlegteDeckungInfo {
        return try {
            val cachedData = unterlegteCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<UnterlegteDeckungInfo>()
            } else {
                val apiData = apiService.getUnterlegte()
                val cacheEntity = UnterlegteCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                unterlegteCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Unterlegten Deckung: ${e.message}", e)
            unterlegteCacheDao.getCache()?.jsonData?.fromJson<UnterlegteDeckungInfo>() ?: UnterlegteDeckungInfo()
        }
    }

    override suspend fun getVariable(): VariableDeckungInfo {
        return try {
            val cachedData = variableCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<VariableDeckungInfo>()
            } else {
                val apiData = apiService.getVariable()
                val cacheEntity = VariableCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                variableCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Variablen Deckung: ${e.message}", e)
            variableCacheDao.getCache()?.jsonData?.fromJson<VariableDeckungInfo>() ?: VariableDeckungInfo()
        }
    }

    override suspend fun getWaagerecht(): WaagerechteDeckungInfo {
        return try {
            val cachedData = waagerechteCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<WaagerechteDeckungInfo>()
            } else {
                val apiData = apiService.getWaagerecht()
                val cacheEntity = WaagerechteCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                waagerechteCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Waagerechten Deckung: ${e.message}", e)
            waagerechteCacheDao.getCache()?.jsonData?.fromJson<WaagerechteDeckungInfo>() ?: WaagerechteDeckungInfo()
        }
    }

    override suspend fun getWaben(): WabenDeckungInfo {
        return try {
            val cachedData = wabenCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<WabenDeckungInfo>()
            } else {
                val apiData = apiService.getWaben()
                val cacheEntity = WabenCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                wabenCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Waben Deckung: ${e.message}", e)
            wabenCacheDao.getCache()?.jsonData?.fromJson<WabenDeckungInfo>() ?: WabenDeckungInfo()
        }
    }

    override suspend fun getRechteck(): WildeRechteckDoppeldeckungInfo {
        return try {
            val cachedData = wildeCacheDao.getCache()
            if (cachedData != null && isCacheValid(cachedData.lastUpdated)) {
                cachedData.jsonData.fromJson<WildeRechteckDoppeldeckungInfo>()
            } else {
                val apiData = apiService.getRechteck()
                val cacheEntity = WildeCacheEntity(
                    jsonData = apiData.toJson(),
                    lastUpdated = System.currentTimeMillis()
                )
                wildeCacheDao.insertCache(cacheEntity)
                apiData
            }
        } catch (e: Exception) {
            Log.e("DeckartenRepository", "Fehler beim Laden der Wilden Rechteck Deckung: ${e.message}", e)
            wildeCacheDao.getCache()?.jsonData?.fromJson<WildeRechteckDoppeldeckungInfo>() ?: WildeRechteckDoppeldeckungInfo()
        }
    }
}