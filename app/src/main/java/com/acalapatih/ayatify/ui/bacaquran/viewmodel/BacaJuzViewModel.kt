package com.acalapatih.ayatify.ui.bacaquran.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.data.source.local.entity.AyatDibaca
import com.acalapatih.ayatify.core.data.source.local.entity.AyatFavorit
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaAyatModel
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaJuzModel
import com.acalapatih.ayatify.core.domain.repository.bookmark.AyatDibacaRepository
import com.acalapatih.ayatify.core.domain.repository.bookmark.AyatFavoritRepository
import com.acalapatih.ayatify.core.domain.usecase.bacaquran.BacaAyatUsecase
import com.acalapatih.ayatify.core.domain.usecase.bacaquran.BacaJuzUsecase
import kotlinx.coroutines.launch

class BacaJuzViewModel(
    application: Application,
    private val usecaseBacaJuz: BacaJuzUsecase,
    private val usecaseBacaAyat: BacaAyatUsecase
): ViewModel() {
    private val _getListAyat = MutableLiveData<Resource<BacaJuzModel>>()
    val getListAyat: LiveData<Resource<BacaJuzModel>> get() = _getListAyat

    private val _getAyat = MutableLiveData<Resource<BacaAyatModel>>()
    val getAyat: LiveData<Resource<BacaAyatModel>> get() = _getAyat

    private val ayatDibacaRepository: AyatDibacaRepository =
        AyatDibacaRepository(application)

    private val ayatFavoritRepository: AyatFavoritRepository =
        AyatFavoritRepository(application)

    fun getListAyat(nomorJuz: String) {
        viewModelScope.launch {
            usecaseBacaJuz.getListAyatJuz(nomorJuz).collect{
                _getListAyat.value = it
            }
        }
    }

    fun getAyat(nomorSurat: String, nomorAyat: String) {
        viewModelScope.launch {
            usecaseBacaAyat.getAyat(nomorSurat, nomorAyat).collect{
                _getAyat.value = it
            }
        }
    }

    fun insertAyatDibaca(ayatDibaca: AyatDibaca) {
        ayatDibacaRepository.insert(ayatDibaca)
    }

    fun insertAyatFavorit(ayatFavorit: AyatFavorit) {
        ayatFavoritRepository.insert(ayatFavorit)
    }
}