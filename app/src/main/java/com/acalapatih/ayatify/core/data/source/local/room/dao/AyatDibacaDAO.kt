package com.acalapatih.ayatify.core.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.acalapatih.ayatify.core.data.source.local.entity.AyatDibaca

@Dao
interface AyatDibacaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ayatDibaca: AyatDibaca)

    @Delete
    fun delete(ayatDibaca: AyatDibaca)

    @Query("SELECT * FROM ayatDibaca ORDER BY id DESC LIMIT 1")
    fun getAyatDibaca(): LiveData<AyatDibaca>

    @Query("SELECT EXISTS(SELECT 1 FROM ayatDibaca WHERE nomorSurat = :nomorSurat AND nomorAyat = :nomorAyat LIMIT 1)")
    fun isFavorite(nomorSurat: String, nomorAyat: String): LiveData<Boolean>
}