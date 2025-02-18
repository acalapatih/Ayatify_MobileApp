package com.acalapatih.ayatify.core.data.source.local.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.acalapatih.ayatify.core.data.source.local.entity.AyatDibaca
import com.acalapatih.ayatify.core.data.source.local.room.dao.AyatDibacaDAO

@Database(entities = [AyatDibaca::class], version = 1)
abstract class AyatDibacaDatabase: RoomDatabase() {
    abstract fun ayatDibacaDao(): AyatDibacaDAO

    companion object {
        @Volatile
        private var INSTANCE: AyatDibacaDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): AyatDibacaDatabase {
            if (INSTANCE == null) {
                synchronized(AyatDibacaDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AyatDibacaDatabase::class.java,
                        "ayat_dibaca_database"
                    ).build()
                }
            }
            return INSTANCE as AyatDibacaDatabase
        }
    }
}