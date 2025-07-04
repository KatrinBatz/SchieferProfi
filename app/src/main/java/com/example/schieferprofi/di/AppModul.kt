package com.example.schieferprofi.di

import androidx.room.Room
import com.example.schieferprofi.data.database.AppDatabase
import com.example.schieferprofi.data.remote.SchieferAPI
import com.example.schieferprofi.data.repository.DeckartenRepositoryImpl
import com.example.schieferprofi.data.repository.DeckartenRepositoryInterface
import com.example.schieferprofi.data.repository.DeckungRepositoryImpl
import com.example.schieferprofi.data.repository.DeckungRepositoryInterface
import com.example.schieferprofi.data.repository.FavoritenRepository
import com.example.schieferprofi.viewmodel.DeckartenViewModel
import com.example.schieferprofi.viewmodel.DeckungViewModel
import com.example.schieferprofi.viewmodel.FavoritenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    single {
        SchieferAPI.retrofitService
    }

    single {
        Room.databaseBuilder(
            get(), // Context wird über Koin bereitgestellt
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    single<DeckungRepositoryInterface> {
        DeckungRepositoryImpl(get())
    }

    single<DeckartenRepositoryInterface> {
        DeckartenRepositoryImpl(get())
    }

    single { get<AppDatabase>().favoritenDao() }
    single { FavoritenRepository(get()) }


    viewModelOf(::DeckungViewModel)
    viewModelOf(::DeckartenViewModel)
    viewModelOf(::FavoritenViewModel)
}