package com.acalapatih.ayatify.core.data.source.local.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.acalapatih.ayatify.core.data.source.local.entity.*
import com.acalapatih.ayatify.core.data.source.local.entity.AlQuraisy
import com.acalapatih.ayatify.core.data.source.local.room.dao.*

@Database(entities = [
    AlFatihah::class,
    AnNas::class,
    AlFalaq::class,
    AlIkhlas::class,
    AlLahab::class,
    AnNasr::class,
    AlKafirun::class,
    AlKausar::class,
    AlMaun::class,
    AlQuraisy::class,
    AlFil::class,
    AlHumazah::class,
    AlAsr::class,
    AtTakasur::class,
    AlQariah::class,
    AlAdiyat::class,
    AlZalzalah::class,
    AlBayyinah::class,
    AlQadr::class,
    AlAlaq::class,
    AtTin::class,
    AsySyarh::class,
    AdDuha::class,
    AlLail::class,
    AsySyam::class,
    AlBalad::class,
    AlFajr::class,
    AlGasyiyah::class,
    AlAla::class,
    AtTariq::class,
    AlBuruj::class,
    AlInsyiqaq::class,
    AlMutaffifin::class,
    AlInfitar::class,
    AtTakwir::class,
    Abasa::class,
    AnNaziat::class,
    AnNaba::class,
    AlMulk::class, ], version = 1)
abstract class SuratDihafalDatabase : RoomDatabase() {
    abstract fun alFatihahDao(): AlFatihahDao
    abstract fun anNasDao(): AnNasDao
    abstract fun alFalaqDao(): AlFalaqDao
    abstract fun alIkhlasDao(): AlIkhlasDao
    abstract fun alLahabDao(): AlLahabDao
    abstract fun anNasrDao(): AnNasrDao
    abstract fun alKafirunDao(): AlKafirunDao
    abstract fun alKausarDao(): AlKausarDao
    abstract fun alMaunDao(): AlMaunDao
    abstract fun alQuraisyDao(): AlQuraisyDao
    abstract fun alFilDao(): AlFilDao
    abstract fun alHumazahDao(): AlHumazahDao
    abstract fun alAsrDao(): AlAsrDao
    abstract fun atTakasurDao(): AtTakasurDao
    abstract fun alQariahDao(): AlQariahDao
    abstract fun alAdiyatDao(): AlAdiyatDao
    abstract fun alZalzalahDao(): AlZalzalahDao
    abstract fun alBayyinahDao(): AlBayyinahDao
    abstract fun alQadrDao(): AlQadrDao
    abstract fun alAlaqDao(): AlAlaqDao
    abstract fun atTinDao(): AtTinDao
    abstract fun asySyarhDao(): AsySyarhDao
    abstract fun adDuhaDao(): AdDuhaDao
    abstract fun alLailDao(): AlLailDao
    abstract fun asySyamDao(): AsySyamDao
    abstract fun alBaladDao(): AlBaladDao
    abstract fun alFajrDao(): AlFajrDao
    abstract fun alGasyiyahDao(): AlGasyiyahDao
    abstract fun alAlaDao(): AlAlaDao
    abstract fun atTariqDao(): AtTariqDao
    abstract fun alBurujDao(): AlBurujDao
    abstract fun alInsyiqaqDao(): AlInsyiqaqDao
    abstract fun alMutaffifinDao(): AlMutaffifinDao
    abstract fun alInfitarDao(): AlInfitarDao
    abstract fun atTakwirDao(): AtTakwirDao
    abstract fun abasaDao(): AbasaDao
    abstract fun anNaziatDao(): AnNaziatDao
    abstract fun anNabaDao(): AnNabaDao
    abstract fun alMulkDao(): AlMulkDao

    companion object {
        @Volatile
        private var INSTANCE: SuratDihafalDatabase? = null

        fun getDatabase(context: Context): SuratDihafalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SuratDihafalDatabase::class.java,
                    "suratDihafal"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}