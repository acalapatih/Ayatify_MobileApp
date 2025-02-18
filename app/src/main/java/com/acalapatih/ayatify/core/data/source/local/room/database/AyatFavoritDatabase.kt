package com.acalapatih.ayatify.core.data.source.local.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.acalapatih.ayatify.core.data.source.local.entity.AyatFavorit
import com.acalapatih.ayatify.core.data.source.local.room.dao.AyatFavoritDAO

@Database(entities = [AyatFavorit::class], version = 1)
abstract class AyatFavoritDatabase: RoomDatabase() {
    abstract fun ayatFavoritDao(): AyatFavoritDAO

    companion object {
        @Volatile
        private var INSTANCE: AyatFavoritDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): AyatFavoritDatabase {
            if (INSTANCE == null) {
                synchronized(AyatFavoritDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AyatFavoritDatabase::class.java,
                        "ayat_favorit_database"
                    )
                        .build()
                }
            }
            return INSTANCE as AyatFavoritDatabase
        }
    }
}