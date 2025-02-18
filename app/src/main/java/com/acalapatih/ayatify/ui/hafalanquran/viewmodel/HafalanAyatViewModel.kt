package com.acalapatih.ayatify.ui.hafalanquran.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.data.source.local.entity.*
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanAyatModel
import com.acalapatih.ayatify.core.domain.repository.bookmark.AyatDihafalRepository
import com.acalapatih.ayatify.core.domain.repository.bookmark.SuratDihafalRepository
import com.acalapatih.ayatify.core.domain.usecase.hafalanquran.HafalanAyatUsecase
import kotlinx.coroutines.launch

class HafalanAyatViewModel(
    application: Application,
    private val usecaseHafalanAyat: HafalanAyatUsecase,
): ViewModel() {
    private val _getAyat = MutableLiveData<Resource<HafalanAyatModel>>()
    val getAyat: LiveData<Resource<HafalanAyatModel>> get() = _getAyat

    private val suratDihafalRepository: SuratDihafalRepository =
        SuratDihafalRepository(application)

    private val ayatDihafalRepository: AyatDihafalRepository =
        AyatDihafalRepository(application)

    fun getAyat(nomorSurat: String, nomorAyat: String) {
        viewModelScope.launch {
            usecaseHafalanAyat.getAyat(nomorSurat, nomorAyat).collect{
                _getAyat.value = it
            }
        }
    }

    fun insertAlFatihah(alFatihah: AlFatihah) {
        suratDihafalRepository.insertAlFatihah(alFatihah)
    }

    fun insertAnNas(anNas: AnNas) {
        suratDihafalRepository.insertAnNas(anNas)
    }

    fun insertAlFalaq(alFalaq: AlFalaq) {
        suratDihafalRepository.insertAlFalaq(alFalaq)
    }

    fun insertAlIkhlas(alIkhlas: AlIkhlas) {
        suratDihafalRepository.insertAlIkhlas(alIkhlas)
    }

    fun insertAlLahab(alLahab: AlLahab) {
        suratDihafalRepository.insertAlLahab(alLahab)
    }

    fun insertAnNasr(anNasr: AnNasr) {
        suratDihafalRepository.insertAnNasr(anNasr)
    }

    fun insertAlKafirun(alKafirun: AlKafirun) {
        suratDihafalRepository.insertAlKafirun(alKafirun)
    }

    fun insertAlKausar(alKausar: AlKausar) {
        suratDihafalRepository.insertAlKausar(alKausar)
    }

    fun insertAlMaun(alMaun: AlMaun) {
        suratDihafalRepository.insertAlMaun(alMaun)
    }

    fun insertAlQuraisy(alQuraisy: AlQuraisy) {
        suratDihafalRepository.insertAlQuraisy(alQuraisy)
    }

    fun insertAlFil(alFil: AlFil) {
        suratDihafalRepository.insertAlFil(alFil)
    }

    fun insertAlHumazah(alHumazah: AlHumazah) {
        suratDihafalRepository.insertAlHumazah(alHumazah)
    }

    fun insertAlAsr(alAsr: AlAsr) {
        suratDihafalRepository.insertAlAsr(alAsr)
    }

    fun insertAtTakasur(atTakasur: AtTakasur) {
        suratDihafalRepository.insertAtTakasur(atTakasur)
    }

    fun insertAlQariah(alQariah: AlQariah) {
        suratDihafalRepository.insertAlQariah(alQariah)
    }

    fun insertAlAdiyat(alAdiyat: AlAdiyat) {
        suratDihafalRepository.insertAlAdiyat(alAdiyat)
    }

    fun insertAlZalzalah(alZalzalah: AlZalzalah) {
        suratDihafalRepository.insertAlZalzalah(alZalzalah)
    }

    fun insertAlBayyinah(alBayyinah: AlBayyinah) {
        suratDihafalRepository.insertAlBayyinah(alBayyinah)
    }

    fun insertAlQadr(alQadr: AlQadr) {
        suratDihafalRepository.insertAlQadr(alQadr)
    }

    fun insertAlAlaq(alAlaq: AlAlaq) {
        suratDihafalRepository.insertAlAlaq(alAlaq)
    }

    fun insertAtTin(atTin: AtTin) {
        suratDihafalRepository.insertAtTin(atTin)
    }

    fun insertAsySyarh(asySyarh: AsySyarh) {
        suratDihafalRepository.insertAsySyarh(asySyarh)
    }

    fun insertAdDuha(adDuha: AdDuha) {
        suratDihafalRepository.insertAdDuha(adDuha)
    }

    fun insertAlLail(alLail: AlLail) {
        suratDihafalRepository.insertAlLail(alLail)
    }

    fun insertAsySyam(asySyam: AsySyam) {
        suratDihafalRepository.insertAsySyam(asySyam)
    }

    fun insertAlBalad(alBalad: AlBalad) {
        suratDihafalRepository.insertAlBalad(alBalad)
    }

    fun insertAlFajr(alFajr: AlFajr) {
        suratDihafalRepository.insertAlFajr(alFajr)
    }

    fun insertAlGasyiyah(alGasyiyah: AlGasyiyah) {
        suratDihafalRepository.insertAlGasyiyah(alGasyiyah)
    }

    fun insertAlAla(alAla: AlAla) {
        suratDihafalRepository.insertAlAla(alAla)
    }

    fun insertAtTariq(atTariq: AtTariq) {
        suratDihafalRepository.insertAtTariq(atTariq)
    }

    fun insertAlBuruj(alBuruj: AlBuruj) {
        suratDihafalRepository.insertAlBuruj(alBuruj)
    }

    fun insertAlInsyiqaq(alInsyiqaq: AlInsyiqaq) {
        suratDihafalRepository.insertAlInsyiqaq(alInsyiqaq)
    }

    fun insertAlMutaffifin(alMutaffifin: AlMutaffifin) {
        suratDihafalRepository.insertAlMutaffifin(alMutaffifin)
    }

    fun insertAlInfitar(alInfitar: AlInfitar) {
        suratDihafalRepository.insertAlInfitar(alInfitar)
    }

    fun insertAtTakwir(atTakwir: AtTakwir) {
        suratDihafalRepository.insertAtTakwir(atTakwir)
    }

    fun insertAbasa(abasa: Abasa) {
        suratDihafalRepository.insertAbasa(abasa)
    }

    fun insertAnNaziat(anNaziat: AnNaziat) {
        suratDihafalRepository.insertAnNaziat(anNaziat)
    }

    fun insertAnNaba(anNaba: AnNaba) {
        suratDihafalRepository.insertAnNaba(anNaba)
    }

    fun insertAlMulk(alMulk: AlMulk) {
        suratDihafalRepository.insertAlMulk(alMulk)
    }

    fun insertAyatDihafal(ayatDihafal: AyatDihafal) {
        ayatDihafalRepository.insertAyatDihafal(ayatDihafal)
    }
}