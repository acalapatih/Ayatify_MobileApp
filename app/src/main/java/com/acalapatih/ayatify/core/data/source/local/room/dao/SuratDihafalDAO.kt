package com.acalapatih.ayatify.core.data.source.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.acalapatih.ayatify.core.data.source.local.entity.*
import com.acalapatih.ayatify.core.data.source.local.entity.AlQuraisy

@Dao
interface AlFatihahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alFatihah: AlFatihah)

    @Query("SELECT * FROM AlFatihah ORDER BY nomorAyat ASC")
    fun getAlFatihah(): LiveData<List<AlFatihah>>
}

@Dao
interface AnNasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(anNas: AnNas)

    @Query("SELECT * FROM AnNas ORDER BY nomorAyat ASC")
    fun getAnNas(): LiveData<List<AnNas>>
}

@Dao
interface AlFalaqDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alFalaq: AlFalaq)

    @Query("SELECT * FROM AlFalaq ORDER BY nomorAyat ASC")
    fun getAlFalaq(): LiveData<List<AlFalaq>>
}

@Dao
interface AlIkhlasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alIkhlas: AlIkhlas)

    @Query("SELECT * FROM AlIkhlas ORDER BY nomorAyat ASC")
    fun getAlIkhlas(): LiveData<List<AlIkhlas>>
}

@Dao
interface AlLahabDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alLahab: AlLahab)

    @Query("SELECT * FROM AlLahab ORDER BY nomorAyat ASC")
    fun getAlLahab(): LiveData<List<AlLahab>>
}

@Dao
interface AnNasrDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(anNasr: AnNasr)

    @Query("SELECT * FROM AnNasr ORDER BY nomorAyat ASC")
    fun getAllAnNasr(): LiveData<List<AnNasr>>
}

@Dao
interface AlKafirunDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alKafirun: AlKafirun)

    @Query("SELECT * FROM AlKafirun ORDER BY nomorAyat ASC")
    fun getAlKafirun(): LiveData<List<AlKafirun>>
}

@Dao
interface AlKausarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alKausar: AlKausar)

    @Query("SELECT * FROM AlKausar ORDER BY nomorAyat ASC")
    fun getAlKausar(): LiveData<List<AlKausar>>
}

@Dao
interface AlMaunDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alMaun: AlMaun)

    @Query("SELECT * FROM AlMaun ORDER BY nomorAyat ASC")
    fun getAlMaun(): LiveData<List<AlMaun>>
}

@Dao
interface AlQuraisyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alQuraisy: AlQuraisy)

    @Query("SELECT * FROM AlQuraisy ORDER BY nomorAyat ASC")
    fun getAlQuraisy(): LiveData<List<AlQuraisy>>
}

@Dao
interface AlFilDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alFil: AlFil)

    @Query("SELECT * FROM AlFil ORDER BY nomorAyat ASC")
    fun getAlFil(): LiveData<List<AlFil>>
}

@Dao
interface AlHumazahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alHumazah: AlHumazah)

    @Query("SELECT * FROM AlHumazah ORDER BY nomorAyat ASC")
    fun getAlHumazah(): LiveData<List<AlHumazah>>
}

@Dao
interface AlAsrDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alAsr: AlAsr)

    @Query("SELECT * FROM AlAsr ORDER BY nomorAyat ASC")
    fun getAlAsr(): LiveData<List<AlAsr>>
}

@Dao
interface AtTakasurDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(atTakasur: AtTakasur)

    @Query("SELECT * FROM AtTakasur ORDER BY nomorAyat ASC")
    fun getAtTakasur(): LiveData<List<AtTakasur>>
}

@Dao
interface AlQariahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alQariah: AlQariah)

    @Query("SELECT * FROM AlQariah ORDER BY nomorAyat ASC")
    fun getAlQariah(): LiveData<List<AlQariah>>
}

@Dao
interface AlAdiyatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alAdiyat: AlAdiyat)

    @Query("SELECT * FROM AlAdiyat ORDER BY nomorAyat ASC")
    fun getAlAdiyat(): LiveData<List<AlAdiyat>>
}

@Dao
interface AlZalzalahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alZalzalah: AlZalzalah)

    @Query("SELECT * FROM AlZalzalah ORDER BY nomorAyat ASC")
    fun getAlZalzalah(): LiveData<List<AlZalzalah>>
}

@Dao
interface AlBayyinahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alBayyinah: AlBayyinah)

    @Query("SELECT * FROM AlBayyinah ORDER BY nomorAyat ASC")
    fun getAlBayyinah(): LiveData<List<AlBayyinah>>
}

@Dao
interface AlQadrDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alQadr: AlQadr)

    @Query("SELECT * FROM AlQadr ORDER BY nomorAyat ASC")
    fun getAlQadr(): LiveData<List<AlQadr>>
}

@Dao
interface AlAlaqDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alAlaq: AlAlaq)

    @Query("SELECT * FROM AlAlaq ORDER BY nomorAyat ASC")
    fun getAlAlaq(): LiveData<List<AlAlaq>>
}

@Dao
interface AtTinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(atTin: AtTin)

    @Query("SELECT * FROM AtTin ORDER BY nomorAyat ASC")
    fun getAtTin(): LiveData<List<AtTin>>
}

@Dao
interface AsySyarhDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(asySyarh: AsySyarh)

    @Query("SELECT * FROM AsySyarh ORDER BY nomorAyat ASC")
    fun getAsySyarh(): LiveData<List<AsySyarh>>
}

@Dao
interface AdDuhaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(adDuha: AdDuha)

    @Query("SELECT * FROM AdDuha ORDER BY nomorAyat ASC")
    fun getAdDuha(): LiveData<List<AdDuha>>
}

@Dao
interface AlLailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alLail: AlLail)

    @Query("SELECT * FROM AlLail ORDER BY nomorAyat ASC")
    fun getAlLail(): LiveData<List<AlLail>>
}

@Dao
interface AsySyamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(asySyam: AsySyam)

    @Query("SELECT * FROM AsySyam ORDER BY nomorAyat ASC")
    fun getAsySyam(): LiveData<List<AsySyam>>
}

@Dao
interface AlBaladDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alBalad: AlBalad)

    @Query("SELECT * FROM AlBalad ORDER BY nomorAyat ASC")
    fun getAlBalad(): LiveData<List<AlBalad>>
}

@Dao
interface AlFajrDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alFajr: AlFajr)

    @Query("SELECT * FROM AlFajr ORDER BY nomorAyat ASC")
    fun getAlFajr(): LiveData<List<AlFajr>>
}

@Dao
interface AlGasyiyahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alGasyiyah: AlGasyiyah)

    @Query("SELECT * FROM AlGasyiyah ORDER BY nomorAyat ASC")
    fun getAlGasyiyah(): LiveData<List<AlGasyiyah>>
}

@Dao
interface AlAlaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alAla: AlAla)

    @Query("SELECT * FROM AlAla ORDER BY nomorAyat ASC")
    fun getAlAla(): LiveData<List<AlAla>>
}

@Dao
interface AtTariqDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(atTariq: AtTariq)

    @Query("SELECT * FROM AtTariq ORDER BY nomorAyat ASC")
    fun getAtTariq(): LiveData<List<AtTariq>>
}

@Dao
interface AlBurujDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alBuruj: AlBuruj)

    @Query("SELECT * FROM AlBuruj ORDER BY nomorAyat ASC")
    fun getAlBuruj(): LiveData<List<AlBuruj>>
}

@Dao
interface AlInsyiqaqDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alInsyiqaq: AlInsyiqaq)

    @Query("SELECT * FROM AlInsyiqaq ORDER BY nomorAyat ASC")
    fun getAlInsyiqaq(): LiveData<List<AlInsyiqaq>>
}

@Dao
interface AlMutaffifinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alMutaffifin: AlMutaffifin)

    @Query("SELECT * FROM AlMutaffifin ORDER BY nomorAyat ASC")
    fun getAlMutaffifin(): LiveData<List<AlMutaffifin>>
}

@Dao
interface AlInfitarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alInfitar: AlInfitar)

    @Query("SELECT * FROM AlInfitar ORDER BY nomorAyat ASC")
    fun getAlInfitar(): LiveData<List<AlInfitar>>
}

@Dao
interface AtTakwirDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(atTakwir: AtTakwir)

    @Query("SELECT * FROM AtTakwir ORDER BY nomorAyat ASC")
    fun getAtTakwir(): LiveData<List<AtTakwir>>
}

@Dao
interface AbasaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(abasa: Abasa)

    @Query("SELECT * FROM Abasa ORDER BY nomorAyat ASC")
    fun getAbasa(): LiveData<List<Abasa>>
}

@Dao
interface AnNaziatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(anNaziat: AnNaziat)

    @Query("SELECT * FROM AnNaziat ORDER BY nomorAyat ASC")
    fun getAnNaziat(): LiveData<List<AnNaziat>>
}

@Dao
interface AnNabaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(anNaba: AnNaba)

    @Query("SELECT * FROM AnNaba ORDER BY nomorAyat ASC")
    fun getAnNaba(): LiveData<List<AnNaba>>
}

@Dao
interface AlMulkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(alMulk: AlMulk)

    @Query("SELECT * FROM AlMulk ORDER BY nomorAyat ASC")
    fun getAlMulk(): LiveData<List<AlMulk>>
}