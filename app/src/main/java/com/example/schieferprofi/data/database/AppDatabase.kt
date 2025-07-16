package com.example.schieferprofi.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.schieferprofi.data.dao.FavoritenDao
import com.example.schieferprofi.data.dao.DeckungDao
import com.example.schieferprofi.data.dao.DeckungsRegelwerkCacheDao
import com.example.schieferprofi.data.dao.Gebindesteigung1CacheDao
import com.example.schieferprofi.data.dao.GebindesteigungCacheDao
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
import com.example.schieferprofi.data.entity.FavoritenDeckart
import com.example.schieferprofi.data.entity.DeckungEntity
import com.example.schieferprofi.data.entity.DeckungsRegelwerkCacheEntity
import com.example.schieferprofi.data.entity.Gebindesteigung1CacheEntity
import com.example.schieferprofi.data.entity.GebindesteigungCacheEntity
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

@TypeConverters(Converters::class)
@Database(
    entities = [
        FavoritenDeckart::class,
        DeckungEntity::class,
        DeckungsRegelwerkCacheEntity::class,
        Gebindesteigung1CacheEntity::class,
        GebindesteigungCacheEntity::class,
        AltdeutscheCacheEntity::class,
        BogenschnittCacheEntity::class,
        DynamischeCacheEntity::class,
        DynamischeRechteckCacheEntity::class,
        GeschlaufteCacheEntity::class,
        GezogeneCacheEntity::class,
        HorizontaleCacheEntity::class,
        KettengebindeCacheEntity::class,
        LineareCacheEntity::class,
        RechteckCacheEntity::class,
        SchuppenCacheEntity::class,
        SpezialFischschuppenCacheEntity::class,
        SpitzwinkelCacheEntity::class,
        UniversalCacheEntity::class,
        UnterlegteCacheEntity::class,
        VariableCacheEntity::class,
        WaagerechteCacheEntity::class,
        WabenCacheEntity::class,
        WildeCacheEntity::class
    ],
    version = 7,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoritenDao(): FavoritenDao
    abstract fun deckungDao(): DeckungDao
    abstract fun deckungsRegelwerkCacheDao(): DeckungsRegelwerkCacheDao
    abstract fun gebindesteigung1CacheDao(): Gebindesteigung1CacheDao
    abstract fun gebindesteigungCacheDao(): GebindesteigungCacheDao
    abstract fun altdeutscheCacheDao(): AltdeutscheCacheDao
    abstract fun bogenschnittCacheDao(): BogenschnittCacheDao
    abstract fun dynamischeCacheDao(): DynamischeCacheDao
    abstract fun dynamischeRechteckCacheDao(): DynamischeRechteckCacheDao
    abstract fun geschlaufteCacheDao(): GeschlaufteCacheDao
    abstract fun gezogeneCacheDao(): GezogeneCacheDao
    abstract fun horizontaleCacheDao(): HorizontaleCacheDao
    abstract fun kettengebindeCacheDao(): KettengebindeCacheDao
    abstract fun lineareCacheDao(): LineareCacheDao
    abstract fun rechteckCacheDao(): RechteckCacheDao
    abstract fun schuppenCacheDao(): SchuppenCacheDao
    abstract fun spezialFischschuppenCacheDao(): SpezialFischschuppenCacheDao
    abstract fun spitzwinkelCacheDao(): SpitzwinkelCacheDao
    abstract fun universalCacheDao(): UniversalCacheDao
    abstract fun unterlegteCacheDao(): UnterlegteCacheDao
    abstract fun variableCacheDao(): VariableCacheDao
    abstract fun waagerechteCacheDao(): WaagerechteCacheDao
    abstract fun wabenCacheDao(): WabenCacheDao
    abstract fun wildeCacheDao(): WildeCacheDao


    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build().also { instance = it }
            }
        }
    }
}