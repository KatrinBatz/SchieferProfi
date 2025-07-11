package com.example.schieferprofi.data.remote

import WabenDeckungInfo
import com.example.schieferprofi.data.model.AltdeutscheDeckungInfo
import com.example.schieferprofi.data.model.BogenschnittDeckungInfo
import com.example.schieferprofi.data.model.Deckung
import com.example.schieferprofi.data.model.DeckungsRegelwerk
import com.example.schieferprofi.data.model.DynamischeDeckungInfo
import com.example.schieferprofi.data.model.DynamischeRechteckDoppeldeckungInfo
import com.example.schieferprofi.data.model.Gebindesteigung1Info
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
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://ktor-schiefer-api.onrender.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface APIService {

    @GET("deckungen")
    suspend fun getDeckungen(): List<Deckung>

    @GET("lookup.php")
    suspend fun getDeckungById(@Query("i") id: String): Deckung

    @GET("/deckungs_regelwerk")
    suspend fun getDeckungsregelwerk(): List<DeckungsRegelwerk>

    @GET("schiefer/gebindesteigung")
    suspend fun getGebindesteigung(): GebindesteigungInfo

    @GET("schiefer/gebindesteigung1")
    suspend fun getGebindesteigung1(): Gebindesteigung1Info

//    @GET("/quiz")
//    suspend fun getQuiz(): List<Quiz>

    @GET("schiefer/altdeutsch")
    suspend fun getAltdeutsche(): AltdeutscheDeckungInfo

    @GET("schiefer/bogenschnitt")
    suspend fun getBogenschnitt(): BogenschnittDeckungInfo

    @GET("schiefer/dynamische")
    suspend fun getDynamische(): DynamischeDeckungInfo

    @GET("schiefer/dynamisch-rechteck")
    suspend fun getDynamischRechteck(): DynamischeRechteckDoppeldeckungInfo

    @GET("schiefer/geschlaufe")
    suspend fun getGeschlaufte(): GeschlaufteDeckungInfo

    @GET("schiefer/gezogene")
    suspend fun getGezogene(): GezogeneDeckungInfo

    @GET("schiefer/horizontale")
    suspend fun getHorizontale(): HorizontaleDeckungInfo

    @GET("schiefer/kettengebinde")
    suspend fun getKettengebinde(): KettengebindeInfo

    @GET("schiefer/lineare")
    suspend fun getLineare(): LineareDeckungInfo

    @GET("schiefer/rechteck")
    suspend fun getRechteckDoppeldeckung(): RechteckDoppeldeckungInfo

    @GET("schiefer/schuppen")
    suspend fun getSchuppen(): SchuppenDeckungInfo

    @GET("schiefer/spezial-fischschuppen")
    suspend fun getFischschuppe(): SpezialFischschuppeDeckungInfo

    @GET("schiefer/spitzwinkel")
    suspend fun getSpitzwinkel(): SpitzwinkelDeckungInfo

    @GET("schiefer/universal")
    suspend fun getUniversal(): UniversalDeckungInfo

    @GET("schiefer/unterlegte")
    suspend fun getUnterlegte(): UnterlegteDeckungInfo

    @GET("schiefer/variable")
    suspend fun getVariable(): VariableDeckungInfo

    @GET("schiefer/waagerecht")
    suspend fun getWaagerecht(): WaagerechteDeckungInfo

    @GET("schiefer/waben")
    suspend fun getWaben(): WabenDeckungInfo

    @GET("schiefer/wilde-rechteck")
    suspend fun getRechteck(): WildeRechteckDoppeldeckungInfo
}

object SchieferAPI {
    val retrofitService: APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}


private fun main() = runBlocking {
    val api = SchieferAPI.retrofitService

    try {
        val response = api.getDeckungsregelwerk()
        print("API response: $response")
    } catch (e: Exception) {
        println("API error: ${e.message}")
    }
}