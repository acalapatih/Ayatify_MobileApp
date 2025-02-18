package com.acalapatih.ayatify.ui.hafalanquran.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.data.source.local.entity.*
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanSuratModel
import com.acalapatih.ayatify.core.domain.repository.bookmark.SuratDihafalRepository
import com.acalapatih.ayatify.core.domain.usecase.hafalanquran.HafalanSuratUseCase
import kotlinx.coroutines.launch

class HafalanSuratViewModel(
    application: Application,
    private val usecaseHafalanSurat: HafalanSuratUseCase
): ViewModel() {
    private val _getListAyat = MutableLiveData<Resource<HafalanSuratModel>>()
    val getListAyat: LiveData<Resource<HafalanSuratModel>> get() = _getListAyat

    private val ayatDihafalRepository: SuratDihafalRepository =
        SuratDihafalRepository(application)

    fun getListAyat(nomorSurat: String) {
        viewModelScope.launch {
            usecaseHafalanSurat.getListAyat(nomorSurat).collect{
                _getListAyat.value = it
            }
        }
    }

    fun getAllAlFatihah(): LiveData<List<AlFatihah>> =
        ayatDihafalRepository.getAllAlFatihah()

    fun getAllAnNas(): LiveData<List<AnNas>> =
        ayatDihafalRepository.getAllAnNas()

    fun getAllAlFalaq(): LiveData<List<AlFalaq>> =
        ayatDihafalRepository.getAllAlFalaq()

    fun getAllAlIkhlas(): LiveData<List<AlIkhlas>> =
        ayatDihafalRepository.getAllAlIkhlas()

    fun getAllAlLahab(): LiveData<List<AlLahab>> =
        ayatDihafalRepository.getAllAlLahab()

    fun getAllAnNasr(): LiveData<List<AnNasr>> =
        ayatDihafalRepository.getAllAnNasr()

    fun getAllAlKafirun(): LiveData<List<AlKafirun>> =
        ayatDihafalRepository.getAllAlKafirun()

    fun getAllAlKausar(): LiveData<List<AlKausar>> =
        ayatDihafalRepository.getAllAlKausar()

    fun getAllAlMaun(): LiveData<List<AlMaun>> =
        ayatDihafalRepository.getAllAlMaun()

    fun getAllAlQuraisy(): LiveData<List<AlQuraisy>> =
        ayatDihafalRepository.getAllAlQuraisy()

    fun getAllAlFil(): LiveData<List<AlFil>> =
        ayatDihafalRepository.getAllAlFil()

    fun getAllAlHumazah(): LiveData<List<AlHumazah>> =
        ayatDihafalRepository.getAllAlHumazah()

    fun getAllAlAsr(): LiveData<List<AlAsr>> =
        ayatDihafalRepository.getAllAlAsr()

    fun getAllAtTakasur(): LiveData<List<AtTakasur>> =
        ayatDihafalRepository.getAllAtTakasur()

    fun getAllAlQariah(): LiveData<List<AlQariah>> =
        ayatDihafalRepository.getAllAlQariah()

    fun getAllAlAdiyat(): LiveData<List<AlAdiyat>> =
        ayatDihafalRepository.getAllAlAdiyat()

    fun getAllAlZalzalah(): LiveData<List<AlZalzalah>> =
        ayatDihafalRepository.getAllAlZalzalah()

    fun getAllAlBayyinah(): LiveData<List<AlBayyinah>> =
        ayatDihafalRepository.getAllAlBayyinah()

    fun getAllAlQadr(): LiveData<List<AlQadr>> =
        ayatDihafalRepository.getAllAlQadr()

    fun getAllAlAlaq(): LiveData<List<AlAlaq>> =
        ayatDihafalRepository.getAllAlAlaq()

    fun getAllAtTin(): LiveData<List<AtTin>> =
        ayatDihafalRepository.getAllAtTin()

    fun getAllAsySyarh(): LiveData<List<AsySyarh>> =
        ayatDihafalRepository.getAllAsySyarh()

    fun getAllAdDuha(): LiveData<List<AdDuha>> =
        ayatDihafalRepository.getAllAdDuha()

    fun getAllAlLail(): LiveData<List<AlLail>> =
        ayatDihafalRepository.getAllAlLail()

    fun getAllAsySyam(): LiveData<List<AsySyam>> =
        ayatDihafalRepository.getAllAsySyam()

    fun getAllAlBalad(): LiveData<List<AlBalad>> =
        ayatDihafalRepository.getAllAlBalad()

    fun getAllAlFajr(): LiveData<List<AlFajr>> =
        ayatDihafalRepository.getAllAlFajr()

    fun getAllAlGasyiyah(): LiveData<List<AlGasyiyah>> =
        ayatDihafalRepository.getAllAlGasyiyah()

    fun getAllAlAla(): LiveData<List<AlAla>> =
        ayatDihafalRepository.getAllAlAla()

    fun getAllAtTariq(): LiveData<List<AtTariq>> =
        ayatDihafalRepository.getAllAtTariq()

    fun getAllAlBuruj(): LiveData<List<AlBuruj>> =
        ayatDihafalRepository.getAllAlBuruj()

    fun getAllAlInsyiqaq(): LiveData<List<AlInsyiqaq>> =
        ayatDihafalRepository.getAllAlInsyiqaq()

    fun getAllAlMutaffifin(): LiveData<List<AlMutaffifin>> =
        ayatDihafalRepository.getAllAlMutaffifin()

    fun getAllAlInfitar(): LiveData<List<AlInfitar>> =
        ayatDihafalRepository.getAllAlInfitar()

    fun getAllAtTakwir(): LiveData<List<AtTakwir>> =
        ayatDihafalRepository.getAllAtTakwir()

    fun getAllAbasa(): LiveData<List<Abasa>> =
        ayatDihafalRepository.getAllAbasa()

    fun getAllAnNaziat(): LiveData<List<AnNaziat>> =
        ayatDihafalRepository.getAllAnNaziat()

    fun getAllAnNaba(): LiveData<List<AnNaba>> =
        ayatDihafalRepository.getAllAnNaba()

    fun getAllAlMulk(): LiveData<List<AlMulk>> =
        ayatDihafalRepository.getAllAlMulk()
}