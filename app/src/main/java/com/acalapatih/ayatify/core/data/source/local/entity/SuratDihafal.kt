package com.acalapatih.ayatify.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "AlFatihah")
@Parcelize
data class AlFatihah(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AnNas")
@Parcelize
data class AnNas(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlFalaq")
@Parcelize
data class AlFalaq(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlIkhlas")
@Parcelize
data class AlIkhlas(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlLahab")
@Parcelize
data class AlLahab(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AnNasr")
@Parcelize
data class AnNasr(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlKafirun")
@Parcelize
data class AlKafirun(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlKausar")
@Parcelize
data class AlKausar(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlMaun")
@Parcelize
data class AlMaun(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlQuraisy")
@Parcelize
data class AlQuraisy(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlFil")
@Parcelize
data class AlFil(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlHumazah")
@Parcelize
data class AlHumazah(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlAsr")
@Parcelize
data class AlAsr(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AtTakasur")
@Parcelize
data class AtTakasur(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlQariah")
@Parcelize
data class AlQariah(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlAdiyat")
@Parcelize
data class AlAdiyat(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlZalzalah")
@Parcelize
data class AlZalzalah(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlBayyinah")
@Parcelize
data class AlBayyinah(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlQadr")
@Parcelize
data class AlQadr(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlAlaq")
@Parcelize
data class AlAlaq(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AtTin")
@Parcelize
data class AtTin(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AsySyarh")
@Parcelize
data class AsySyarh(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AdDuha")
@Parcelize
data class AdDuha(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlLail")
@Parcelize
data class AlLail(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AsySyam")
@Parcelize
data class AsySyam(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlBalad")
@Parcelize
data class AlBalad(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlFajr")
@Parcelize
data class AlFajr(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlGasyiyah")
@Parcelize
data class AlGasyiyah(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlAla")
@Parcelize
data class AlAla(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AtTariq")
@Parcelize
data class AtTariq(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlBuruj")
@Parcelize
data class AlBuruj(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlInsyiqaq")
@Parcelize
data class AlInsyiqaq(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlMutaffifin")
@Parcelize
data class AlMutaffifin(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlInfitar")
@Parcelize
data class AlInfitar(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AtTakwir")
@Parcelize
data class AtTakwir(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "Abasa")
@Parcelize
data class Abasa(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AnNaziat")
@Parcelize
data class AnNaziat(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AnNaba")
@Parcelize
data class AnNaba(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable

@Entity(tableName = "AlMulk")
@Parcelize
data class AlMulk(
    @PrimaryKey
    val idAyat: Int,
    val namaSurat: String,
    val nomorAyat: Int,
    val statusAyat: String
) : Parcelable
