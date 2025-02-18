package com.acalapatih.ayatify.core.data.source.local.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.acalapatih.ayatify.core.data.source.local.entity.JuzQuran
import com.acalapatih.ayatify.core.data.source.local.room.dao.ListJuzDAO

@Database(entities = [JuzQuran::class], version = 1)
abstract class ListJuzDatabase: RoomDatabase() {
    abstract fun listJuzDAO(): ListJuzDAO

    companion object {
        @Volatile
        private var INSTANCE: ListJuzDatabase? = null

        fun getDatabase(context: Context): ListJuzDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ListJuzDatabase::class.java,
                    "listJuz"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}