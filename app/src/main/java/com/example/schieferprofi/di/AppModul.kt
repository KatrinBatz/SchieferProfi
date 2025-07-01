package com.example.schieferprofi.di

import com.example.schieferprofi.data.remote.SchieferAPI
import com.example.schieferprofi.data.repository.AltdeutschRepositoryImpl
import com.example.schieferprofi.data.repository.AltdeutschRepositoryInterface
import com.example.schieferprofi.data.repository.BogenschnittRepositoryImpl
import com.example.schieferprofi.data.repository.BogenschnittRepositoryInterface
import com.example.schieferprofi.data.repository.DeckungRepositoryImpl
import com.example.schieferprofi.data.repository.DeckungRepositoryInterface
import com.example.schieferprofi.data.repository.DynamischeRechteckRepositoryImpl
import com.example.schieferprofi.data.repository.DynamischeRechteckRepositoryInterface
import com.example.schieferprofi.data.repository.DynamischeRepositoryImpl
import com.example.schieferprofi.data.repository.DynamischeRepositoryInterface
import com.example.schieferprofi.data.repository.GeschlaufteRepositoryImpl
import com.example.schieferprofi.data.repository.GeschlaufteRepositoryInterface
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

    single<AltdeutschRepositoryInterface> {
        AltdeutschRepositoryImpl( get())
    }

    single<BogenschnittRepositoryInterface> {
        BogenschnittRepositoryImpl(get())
    }

    single<DynamischeRepositoryInterface> {
        DynamischeRepositoryImpl(get())
    }

    single<DynamischeRechteckRepositoryInterface> {
        DynamischeRechteckRepositoryImpl(get())
    }

    single<GeschlaufteRepositoryInterface> {
        GeschlaufteRepositoryImpl(get())
    }

    viewModelOf(::DeckungViewModel)
    viewModelOf(::AltdeutschesViewModel)
    viewModelOf( ::BogenschnittViewModel)
    viewModelOf( ::DynamischeViewModel)
    viewModelOf( ::DynamischeRechteckViewModel)
    viewModelOf( ::GeschlaufteViewModel)

}