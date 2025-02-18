package com.acalapatih.ayatify.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "juzQuran")
@Parcelize
data class JuzQuran(
    @PrimaryKey val idJuz: String,
    val nomorJuz: String,
    val namaJuz: String,
    val infoJuz: String
) : Parcelable