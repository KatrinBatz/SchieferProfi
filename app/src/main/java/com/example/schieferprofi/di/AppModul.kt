package com.example.schieferprofi.di

import com.example.schieferprofi.data.remote.SchieferAPI
import com.example.schieferprofi.data.repository.DeckartenRepositoryImpl
import com.example.schieferprofi.data.repository.DeckartenRepositoryInterface
import com.example.schieferprofi.data.repository.DeckungRepositoryImpl
import com.example.schieferprofi.data.repository.DeckungRepositoryInterface
import com.example.schieferprofi.viewmodel.AltdeutschesViewModel
import com.example.schieferprofi.viewmodel.BogenschnittViewModel
import com.example.schieferprofi.viewmodel.DeckungViewModel
import com.example.schieferprofi.viewmodel.DynamischeRechteckViewModel
import com.example.schieferprofi.viewmodel.DynamischeViewModel
import com.example.schieferprofi.viewmodel.GeschlaufteViewModel
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
    viewModelOf(::AltdeutschesViewModel)
    viewModelOf( ::BogenschnittViewModel)
    viewModelOf( ::DynamischeViewModel)
    viewModelOf( ::DynamischeRechteckViewModel)
    viewModelOf( ::GeschlaufteViewModel)

}