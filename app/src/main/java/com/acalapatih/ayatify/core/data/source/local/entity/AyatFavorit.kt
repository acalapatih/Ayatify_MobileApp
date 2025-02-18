package com.acalapatih.ayatify.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Entity(primaryKeys = ["nomorSurat", "nomorAyat"])
@Parcelize
data class AyatFavorit(
    val nomorSurat: String,
    val namaSurat: String? = null,
    val nomorAyat: String,
    val lafadzAyat: String,
    val terjemahanAyat: String
) : Parcelable
