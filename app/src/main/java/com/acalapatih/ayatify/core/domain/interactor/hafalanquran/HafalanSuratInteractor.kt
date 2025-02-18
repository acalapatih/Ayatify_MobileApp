package com.acalapatih.ayatify.core.domain.interactor.hafalanquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanSuratModel
import com.acalapatih.ayatify.core.domain.repository.hafalanquran.HafalanSuratRepository
import com.acalapatih.ayatify.core.domain.usecase.hafalanquran.HafalanSuratUseCase
import kotlinx.coroutines.flow.Flow

class HafalanSuratInteractor(
    private val repository: HafalanSuratRepository
): HafalanSuratUseCase {
    override fun getListAyat(nomorSurat: String): Flow<Resource<HafalanSuratModel>> =
        repository.getListAyat(nomorSurat)
}