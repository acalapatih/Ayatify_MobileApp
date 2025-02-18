package com.acalapatih.ayatify.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class AyatDibaca(
    @PrimaryKey
    val id: Int = 1,
    val nomorSurat: String,
    val namaSurat: String? = null,
    val nomorAyat: String
) : Parcelable