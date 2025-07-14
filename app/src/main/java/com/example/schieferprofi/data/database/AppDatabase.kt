package com.example.schieferprofi.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.schieferprofi.data.dao.DeckungDao
import com.example.schieferprofi.data.dao.FavoritenDao
import com.example.schieferprofi.data.entity.DeckungEntity
import com.example.schieferprofi.data.entity.FavoritenDeckart

@TypeConverters(Converters::class)
@Database(entities = [FavoritenDeckart::class, DeckungEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoritenDao(): FavoritenDao
    abstract fun deckungDao(): DeckungDao


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