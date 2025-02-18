package com.acalapatih.ayatify.core.domain.repository.bookmark

import android.app.Application
import com.acalapatih.ayatify.core.data.source.local.entity.Abasa
import com.acalapatih.ayatify.core.data.source.local.entity.AdDuha
import com.acalapatih.ayatify.core.data.source.local.entity.AlAdiyat
import com.acalapatih.ayatify.core.data.source.local.entity.AlAla
import com.acalapatih.ayatify.core.data.source.local.entity.AlAlaq
import com.acalapatih.ayatify.core.data.source.local.entity.AlAsr
import com.acalapatih.ayatify.core.data.source.local.entity.AlBalad
import com.acalapatih.ayatify.core.data.source.local.entity.AlBayyinah
import com.acalapatih.ayatify.core.data.source.local.entity.AlBuruj
import com.acalapatih.ayatify.core.data.source.local.entity.AlFajr
import com.acalapatih.ayatify.core.data.source.local.entity.AlFalaq
import com.acalapatih.ayatify.core.data.source.local.entity.AlFatihah
import com.acalapatih.ayatify.core.data.source.local.entity.AlFil
import com.acalapatih.ayatify.core.data.source.local.entity.AlGasyiyah
import com.acalapatih.ayatify.core.data.source.local.entity.AlHumazah
import com.acalapatih.ayatify.core.data.source.local.entity.AlIkhlas
import com.acalapatih.ayatify.core.data.source.local.entity.AlInfitar
import com.acalapatih.ayatify.core.data.source.local.entity.AlInsyiqaq
import com.acalapatih.ayatify.core.data.source.local.entity.AlKafirun
import com.acalapatih.ayatify.core.data.source.local.entity.AlKausar
import com.acalapatih.ayatify.core.data.source.local.entity.AlLahab
import com.acalapatih.ayatify.core.data.source.local.entity.AlLail
import com.acalapatih.ayatify.core.data.source.local.entity.AlMaun
import com.acalapatih.ayatify.core.data.source.local.entity.AlMulk
import com.acalapatih.ayatify.core.data.source.local.entity.AlMutaffifin
import com.acalapatih.ayatify.core.data.source.local.entity.AlQadr
import com.acalapatih.ayatify.core.data.source.local.entity.AlQariah
import com.acalapatih.ayatify.core.data.source.local.entity.AlQuraisy
import com.acalapatih.ayatify.core.data.source.local.entity.AlZalzalah
import com.acalapatih.ayatify.core.data.source.local.entity.AnNaba
import com.acalapatih.ayatify.core.data.source.local.entity.AnNas
import com.acalapatih.ayatify.core.data.source.local.entity.AnNasr
import com.acalapatih.ayatify.core.data.source.local.entity.AnNaziat
import com.acalapatih.ayatify.core.data.source.local.entity.AsySyam
import com.acalapatih.ayatify.core.data.source.local.entity.AsySyarh
import com.acalapatih.ayatify.core.data.source.local.entity.AtTakasur
import com.acalapatih.ayatify.core.data.source.local.entity.AtTakwir
import com.acalapatih.ayatify.core.data.source.local.entity.AtTariq
import com.acalapatih.ayatify.core.data.source.local.entity.AtTin
import com.acalapatih.ayatify.core.data.source.local.room.dao.AbasaDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AdDuhaDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlAdiyatDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlAlaDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlAlaqDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlAsrDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlBaladDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlBayyinahDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlBurujDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlFajrDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlFalaqDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlFatihahDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlFilDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlGasyiyahDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlHumazahDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlIkhlasDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlInfitarDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlInsyiqaqDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlKafirunDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlKausarDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlLahabDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlLailDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlMaunDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlMulkDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlMutaffifinDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlQadrDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlQariahDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlQuraisyDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AlZalzalahDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AnNabaDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AnNasDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AnNasrDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AnNaziatDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AsySyamDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AsySyarhDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AtTakasurDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AtTakwirDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AtTariqDao
import com.acalapatih.ayatify.core.data.source.local.room.dao.AtTinDao
import com.acalapatih.ayatify.core.data.source.local.room.database.SuratDihafalDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class SuratDihafalRepository(application: Application) {
    private val alFatihahDao: AlFatihahDao
    private val anNasDao: AnNasDao
    private val alFalaqDao: AlFalaqDao
    private val alIkhlasDao: AlIkhlasDao
    private val alLahabDao: AlLahabDao
    private val anNasrDao: AnNasrDao
    private val alKafirunDao: AlKafirunDao
    private val alKausarDao: AlKausarDao
    private val alMaunDao: AlMaunDao
    private val alQuraisyDao: AlQuraisyDao
    private val alFilDao: AlFilDao
    private val alHumazahDao: AlHumazahDao
    private val alAsrDao: AlAsrDao
    private val atTakasurDao: AtTakasurDao
    private val alQariahDao: AlQariahDao
    private val alAdiyatDao: AlAdiyatDao
    private val alZalzalahDao: AlZalzalahDao
    private val alBayyinahDao: AlBayyinahDao
    private val alQadrDao: AlQadrDao
    private val alAlaqDao: AlAlaqDao
    private val atTinDao: AtTinDao
    private val asySyarhDao: AsySyarhDao
    private val adDuhaDao: AdDuhaDao
    private val alLailDao: AlLailDao
    private val asySyamDao: AsySyamDao
    private val alBaladDao: AlBaladDao
    private val alFajrDao: AlFajrDao
    private val alGasyiyahDao: AlGasyiyahDao
    private val alAlaDao: AlAlaDao
    private val atTariqDao: AtTariqDao
    private val alBurujDao: AlBurujDao
    private val alInsyiqaqDao: AlInsyiqaqDao
    private val alMutaffifinDao: AlMutaffifinDao
    private val alInfitarDao: AlInfitarDao
    private val atTakwirDao: AtTakwirDao
    private val abasaDao: AbasaDao
    private val anNaziatDao: AnNaziatDao
    private val anNabaDao: AnNabaDao
    private val alMulkDao: AlMulkDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = SuratDihafalDatabase.getDatabase(application)
        alFatihahDao = db.alFatihahDao()
        anNasDao = db.anNasDao()
        alFalaqDao = db.alFalaqDao()
        alIkhlasDao = db.alIkhlasDao()
        alLahabDao = db.alLahabDao()
        anNasrDao = db.anNasrDao()
        alKafirunDao = db.alKafirunDao()
        alKausarDao = db.alKausarDao()
        alMaunDao = db.alMaunDao()
        alQuraisyDao = db.alQuraisyDao()
        alFilDao = db.alFilDao()
        alHumazahDao = db.alHumazahDao()
        alAsrDao = db.alAsrDao()
        atTakasurDao = db.atTakasurDao()
        alQariahDao = db.alQariahDao()
        alAdiyatDao = db.alAdiyatDao()
        alZalzalahDao = db.alZalzalahDao()
        alBayyinahDao = db.alBayyinahDao()
        alQadrDao = db.alQadrDao()
        alAlaqDao = db.alAlaqDao()
        atTinDao = db.atTinDao()
        asySyarhDao = db.asySyarhDao()
        adDuhaDao = db.adDuhaDao()
        alLailDao = db.alLailDao()
        asySyamDao = db.asySyamDao()
        alBaladDao = db.alBaladDao()
        alFajrDao = db.alFajrDao()
        alGasyiyahDao = db.alGasyiyahDao()
        alAlaDao = db.alAlaDao()
        atTariqDao = db.atTariqDao()
        alBurujDao = db.alBurujDao()
        alInsyiqaqDao = db.alInsyiqaqDao()
        alMutaffifinDao = db.alMutaffifinDao()
        alInfitarDao = db.alInfitarDao()
        atTakwirDao = db.atTakwirDao()
        abasaDao = db.abasaDao()
        anNaziatDao = db.anNaziatDao()
        anNabaDao = db.anNabaDao()
        alMulkDao = db.alMulkDao()
    }

    //Al-Fatihah
    fun insertAlFatihah(alFatihah: AlFatihah) {
        executorService.execute { alFatihahDao.insert(alFatihah) }
    }
    fun getAllAlFatihah() = alFatihahDao.getAlFatihah()

    //An-Nas
    fun insertAnNas(anNas: AnNas) {
        executorService.execute { anNasDao.insert(anNas) }
    }
    fun getAllAnNas() = anNasDao.getAnNas()

    //Al-Falaq
    fun insertAlFalaq(alFalaq: AlFalaq) {
        executorService.execute { alFalaqDao.insert(alFalaq) }
    }
    fun getAllAlFalaq() = alFalaqDao.getAlFalaq()

    //Al-Ikhlas
    fun insertAlIkhlas(alIkhlas: AlIkhlas) {
        executorService.execute { alIkhlasDao.insert(alIkhlas) }
    }
    fun getAllAlIkhlas() = alIkhlasDao.getAlIkhlas()

    //Al-Lahab
    fun insertAlLahab(alLahab: AlLahab) {
        executorService.execute { alLahabDao.insert(alLahab) }
    }
    fun getAllAlLahab() = alLahabDao.getAlLahab()

    //An-Nasr
    fun insertAnNasr(anNasr: AnNasr) {
        executorService.execute { anNasrDao.insert(anNasr) }
    }
    fun getAllAnNasr() = anNasrDao.getAllAnNasr()

    //Al-Kafirun
    fun insertAlKafirun(alKafirun: AlKafirun) {
        executorService.execute { alKafirunDao.insert(alKafirun) }
    }
    fun getAllAlKafirun() = alKafirunDao.getAlKafirun()

    //Al-Kausar
    fun insertAlKausar(alKausar: AlKausar) {
        executorService.execute { alKausarDao.insert(alKausar) }
    }
    fun getAllAlKausar() = alKausarDao.getAlKausar()

    //Al-Maun
    fun insertAlMaun(alMaun: AlMaun) {
        executorService.execute { alMaunDao.insert(alMaun) }
    }
    fun getAllAlMaun() = alMaunDao.getAlMaun()

    //Al-Quraisy
    fun insertAlQuraisy(alQuraisy: AlQuraisy) {
        executorService.execute { alQuraisyDao.insert(alQuraisy) }
    }
    fun getAllAlQuraisy() = alQuraisyDao.getAlQuraisy()

    //Al-Fil
    fun insertAlFil(alFil: AlFil) {
        executorService.execute { alFilDao.insert(alFil) }
    }
    fun getAllAlFil() = alFilDao.getAlFil()

    //Al-Humazah
    fun insertAlHumazah(alHumazah: AlHumazah) {
        executorService.execute { alHumazahDao.insert(alHumazah) }
    }
    fun getAllAlHumazah() = alHumazahDao.getAlHumazah()

    //Al-Asr
    fun insertAlAsr(alAsr: AlAsr) {
        executorService.execute { alAsrDao.insert(alAsr) }
    }
    fun getAllAlAsr() = alAsrDao.getAlAsr()

    //At-Takasur
    fun insertAtTakasur(atTakasur: AtTakasur) {
        executorService.execute { atTakasurDao.insert(atTakasur) }
    }
    fun getAllAtTakasur() = atTakasurDao.getAtTakasur()

    //Al-Qariah
    fun insertAlQariah(alQariah: AlQariah) {
        executorService.execute { alQariahDao.insert(alQariah) }
    }
    fun getAllAlQariah() = alQariahDao.getAlQariah()

    //Al-Adiyat
    fun insertAlAdiyat(alAdiyat: AlAdiyat) {
        executorService.execute { alAdiyatDao.insert(alAdiyat) }
    }
    fun getAllAlAdiyat() = alAdiyatDao.getAlAdiyat()

    //Al-Zalzalah
    fun insertAlZalzalah(alZalzalah: AlZalzalah) {
        executorService.execute { alZalzalahDao.insert(alZalzalah) }
    }
    fun getAllAlZalzalah() = alZalzalahDao.getAlZalzalah()

    //Al-Bayyinah
    fun insertAlBayyinah(alBayyinah: AlBayyinah) {
        executorService.execute { alBayyinahDao.insert(alBayyinah) }
    }
    fun getAllAlBayyinah() = alBayyinahDao.getAlBayyinah()

    //Al-Qadr
    fun insertAlQadr(alQadr: AlQadr) {
        executorService.execute { alQadrDao.insert(alQadr) }
    }
    fun getAllAlQadr() = alQadrDao.getAlQadr()

    //Al-Alaq
    fun insertAlAlaq(alAlaq: AlAlaq) {
        executorService.execute { alAlaqDao.insert(alAlaq) }
    }
    fun getAllAlAlaq() = alAlaqDao.getAlAlaq()

    //At-Tin
    fun insertAtTin(atTin: AtTin) {
        executorService.execute { atTinDao.insert(atTin) }
    }
    fun getAllAtTin() = atTinDao.getAtTin()

    //Asy-Syarh
    fun insertAsySyarh(asySyarh: AsySyarh){
        executorService.execute { asySyarhDao.insert(asySyarh) }
    }
    fun getAllAsySyarh() = asySyarhDao.getAsySyarh()

    //Ad-Duha
    fun insertAdDuha(adDuha: AdDuha){
        executorService.execute { adDuhaDao.insert(adDuha) }
    }
    fun getAllAdDuha() = adDuhaDao.getAdDuha()

    //Al-Lail
    fun insertAlLail(alLail: AlLail){
        executorService.execute { alLailDao.insert(alLail) }
    }
    fun getAllAlLail() = alLailDao.getAlLail()

    //Asy-Syam
    fun insertAsySyam(asySyam: AsySyam){
        executorService.execute { asySyamDao.insert(asySyam) }
    }
    fun getAllAsySyam() = asySyamDao.getAsySyam()

    //Al-Balad
    fun insertAlBalad(alBalad: AlBalad){
        executorService.execute { alBaladDao.insert(alBalad) }
    }
    fun getAllAlBalad() = alBaladDao.getAlBalad()

    //Al-Fajr
    fun insertAlFajr(alFajr: AlFajr){
        executorService.execute { alFajrDao.insert(alFajr) }
    }
    fun getAllAlFajr() = alFajrDao.getAlFajr()

    //Al-Gasyiyah
    fun insertAlGasyiyah(alGasyiyah: AlGasyiyah){
        executorService.execute { alGasyiyahDao.insert(alGasyiyah) }
    }
    fun getAllAlGasyiyah() = alGasyiyahDao.getAlGasyiyah()

    //Al-Ala
    fun insertAlAla(alAla: AlAla){
        executorService.execute { alAlaDao.insert(alAla) }
    }
    fun getAllAlAla() = alAlaDao.getAlAla()

    //At-Tariq
    fun insertAtTariq(atTariq: AtTariq){
        executorService.execute { atTariqDao.insert(atTariq) }
    }
    fun getAllAtTariq() = atTariqDao.getAtTariq()

    //Al-Buruj
    fun insertAlBuruj(alBuruj: AlBuruj){
        executorService.execute { alBurujDao.insert(alBuruj) }
    }
    fun getAllAlBuruj() = alBurujDao.getAlBuruj()

    //Al-Insyiqaq
    fun insertAlInsyiqaq(alInsyiqaq: AlInsyiqaq){
        executorService.execute { alInsyiqaqDao.insert(alInsyiqaq) }
    }
    fun getAllAlInsyiqaq() = alInsyiqaqDao.getAlInsyiqaq()

    //Al-Mutaffifin
    fun insertAlMutaffifin(alMutaffifin: AlMutaffifin){
        executorService.execute { alMutaffifinDao.insert(alMutaffifin) }
    }
    fun getAllAlMutaffifin() = alMutaffifinDao.getAlMutaffifin()

    //Al-Infitar
    fun insertAlInfitar(alInfitar: AlInfitar){
        executorService.execute { alInfitarDao.insert(alInfitar) }
    }
    fun getAllAlInfitar() = alInfitarDao.getAlInfitar()

    //At-Takwir
    fun insertAtTakwir(atTakwir: AtTakwir) {
        executorService.execute { atTakwirDao.insert(atTakwir) }
    }
    fun getAllAtTakwir() = atTakwirDao.getAtTakwir()

    //Abasa
    fun insertAbasa(abasa: Abasa) {
        executorService.execute { abasaDao.insert(abasa) }
    }
    fun getAllAbasa() = abasaDao.getAbasa()

    //An-Naziat
    fun insertAnNaziat(anNaziat: AnNaziat) {
        executorService.execute { anNaziatDao.insert(anNaziat) }
    }
    fun getAllAnNaziat() = anNaziatDao.getAnNaziat()

    //An-Naba
    fun insertAnNaba(anNaba: AnNaba) {
        executorService.execute { anNabaDao.insert(anNaba) }
    }
    fun getAllAnNaba() = anNabaDao.getAnNaba()

    //Al-Mulk
    fun insertAlMulk(alMulk: AlMulk) {
        executorService.execute { alMulkDao.insert(alMulk) }
    }
    fun getAllAlMulk() = alMulkDao.getAlMulk()
}
