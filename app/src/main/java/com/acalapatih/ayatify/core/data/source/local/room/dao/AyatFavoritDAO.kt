package com.acalapatih.ayatify.core.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.acalapatih.ayatify.core.data.source.local.entity.AyatFavorit

@Dao
interface AyatFavoritDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ayatFavorit: AyatFavorit)

    @Delete
    fun delete(ayatFavorit: AyatFavorit)

    @Query("SELECT * FROM ayatFavorit")
    fun getAllAyatFavorit(): LiveData<List<AyatFavorit>>
}