package com.example.schieferprofi.di

import androidx.room.Room
import com.example.schieferprofi.data.database.AppDatabase
import com.example.schieferprofi.data.remote.SchieferAPI
import com.example.schieferprofi.data.repository.DeckartenRepositoryImpl
import com.example.schieferprofi.data.repository.DeckartenRepositoryInterface
import com.example.schieferprofi.data.repository.DeckungRepository
import com.example.schieferprofi.data.repository.DeckungsRegelwerkRepositoryImpl
import com.example.schieferprofi.data.repository.DeckungsRegelwerkRepositoryInterface
import com.example.schieferprofi.data.repository.FavoritenRepository
import com.example.schieferprofi.data.repository.GebindesteigungRepositoryImpl
import com.example.schieferprofi.data.repository.GebindesteigungRepositoryInterface
import com.example.schieferprofi.viewmodel.DeckartenViewModel
import com.example.schieferprofi.viewmodel.DeckungViewModel
import com.example.schieferprofi.viewmodel.DeckungsRegelwerkViewModel
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import com.example.schieferprofi.viewmodel.GebindesteigungViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel

val appModule = module {

    single {
        SchieferAPI.retrofitService
    }

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration(true)
            .build()
    }

    single { DeckungRepository(api = get(), dao = get()) }

    single<DeckartenRepositoryInterface> {
        DeckartenRepositoryImpl(
            apiService = get(),
            altdeutscheCacheDao = get(),
            bogenschnittCacheDao = get(),
            dynamischeCacheDao = get(),
            dynamischeRechteckCacheDao = get(),
            geschlaufteCacheDao = get(),
            gezogeneCacheDao = get(),
            horizontaleCacheDao = get(),
            kettengebindeCacheDao = get(),
            lineareCacheDao = get(),
            rechteckCacheDao = get(),
            schuppenCacheDao = get(),
            spezialFischschuppenCacheDao = get(),
            spitzwinkelCacheDao = get(),
            universalCacheDao = get(),
            unterlegteCacheDao = get(),
            variableCacheDao = get(),
            waagerechteCacheDao = get(),
            wabenCacheDao = get(),
            wildeCacheDao = get()
        )
    }

    single<GebindesteigungRepositoryInterface>{
        GebindesteigungRepositoryImpl(
            apiService = get(),
            gebindesteigungCacheDao = get(),
            gebindesteigung1CacheDao = get(),
            context = androidContext()
        )
    }

    single<DeckungsRegelwerkRepositoryInterface> {
        DeckungsRegelwerkRepositoryImpl(
            apiService = get(),
            deckungsRegelwerkCacheDao = get(),
            context = androidContext()
        )
    }
    
    // Cache DAOs für Gebindesteigung und DeckungsRegelwerk
    single { get<AppDatabase>().gebindesteigungCacheDao() }
    single { get<AppDatabase>().gebindesteigung1CacheDao() }
    single { get<AppDatabase>().deckungsRegelwerkCacheDao() }

    single { get<AppDatabase>().favoritenDao() }
    single { FavoritenRepository(get()) }
    single { get<AppDatabase>().deckungDao() }
    
    // Cache DAOs
    single { get<AppDatabase>().altdeutscheCacheDao() }
    single { get<AppDatabase>().bogenschnittCacheDao() }
    single { get<AppDatabase>().dynamischeCacheDao() }
    single { get<AppDatabase>().dynamischeRechteckCacheDao() }
    single { get<AppDatabase>().geschlaufteCacheDao() }
    single { get<AppDatabase>().gezogeneCacheDao() }
    single { get<AppDatabase>().horizontaleCacheDao() }
    single { get<AppDatabase>().kettengebindeCacheDao() }
    single { get<AppDatabase>().lineareCacheDao() }
    single { get<AppDatabase>().rechteckCacheDao() }
    single { get<AppDatabase>().schuppenCacheDao() }
    single { get<AppDatabase>().spezialFischschuppenCacheDao() }
    single { get<AppDatabase>().spitzwinkelCacheDao() }
    single { get<AppDatabase>().universalCacheDao() }
    single { get<AppDatabase>().unterlegteCacheDao() }
    single { get<AppDatabase>().variableCacheDao() }
    single { get<AppDatabase>().waagerechteCacheDao() }
    single { get<AppDatabase>().wabenCacheDao() }
    single { get<AppDatabase>().wildeCacheDao() }



    viewModelOf(::DeckungViewModel)
    viewModel { DeckartenViewModel(get(), androidContext()) }
    viewModelOf(::FavoritenViewModel)
    viewModel { GebindesteigungViewModel(get(), androidContext()) }
    viewModel { DeckungsRegelwerkViewModel(get(), androidContext()) }

}