package com.acalapatih.ayatify.core.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.acalapatih.ayatify.core.data.source.local.entity.AyatDihafal

@Dao
interface AyatDihafalDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAyatDihafal(ayatDihafal: AyatDihafal)

    @Query("SELECT * FROM ayatDihafal ORDER BY id DESC LIMIT 1")
    fun getAyatDihafal(): LiveData<AyatDihafal>

    @Query("SELECT waktuHafalan FROM ayatDihafal ORDER BY id ASC LIMIT 1")
    fun getWaktuHafalan(): LiveData<String>

    @Query("SELECT COUNT(*) FROM ayatDihafal")
    fun getJumlahAyatDihafal(): LiveData<Int>
}