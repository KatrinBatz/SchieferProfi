package com.example.schieferprofi.di

import com.example.schieferprofi.data.remote.SchieferAPI
import com.example.schieferprofi.data.repository.DeckartenRepositoryImpl
import com.example.schieferprofi.data.repository.DeckartenRepositoryInterface
import com.example.schieferprofi.data.repository.DeckungRepositoryImpl
import com.example.schieferprofi.data.repository.DeckungRepositoryInterface
import com.example.schieferprofi.viewmodel.DeckartenViewModel
import com.example.schieferprofi.viewmodel.DeckungViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    single {
        SchieferAPI.retrofitService
    }

    single<DeckungRepositoryInterface> {
        DeckungRepositoryImpl(get())
    }

    single<DeckartenRepositoryInterface> {
        DeckartenRepositoryImpl(get())
    }


    viewModelOf(::DeckungViewModel)
    viewModelOf(::DeckartenViewModel)
}