package com.acalapatih.ayatify.core.data.source.local.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.acalapatih.ayatify.core.data.source.local.entity.AyatDihafal
import com.acalapatih.ayatify.core.data.source.local.room.dao.AyatDihafalDAO

@Database(entities = [AyatDihafal::class], version = 1)
abstract class AyatDihafalDatabase: RoomDatabase() {
    abstract fun ayatDihafalDao(): AyatDihafalDAO

    companion object {
        @Volatile
        private var INSTANCE: AyatDihafalDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): AyatDihafalDatabase {
            if (INSTANCE == null) {
                synchronized(AyatDihafalDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AyatDihafalDatabase::class.java,
                        "ayatDihafal"
                    ).build()
                }
            }
            return INSTANCE as AyatDihafalDatabase
        }
    }
}