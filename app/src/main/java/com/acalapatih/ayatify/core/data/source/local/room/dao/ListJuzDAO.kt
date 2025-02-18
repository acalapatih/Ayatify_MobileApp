package com.acalapatih.ayatify.core.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.acalapatih.ayatify.core.data.source.local.entity.JuzQuran

@Dao
interface ListJuzDAO {
    @Query("SELECT * FROM juzQuran")
    fun getAllJuzQuran(): LiveData<List<JuzQuran>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(juzQuran: List<JuzQuran>)
}