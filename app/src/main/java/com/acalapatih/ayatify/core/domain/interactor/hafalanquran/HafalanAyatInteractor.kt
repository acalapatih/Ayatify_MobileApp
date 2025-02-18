package com.acalapatih.ayatify.core.domain.interactor.hafalanquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanAyatModel
import com.acalapatih.ayatify.core.domain.repository.hafalanquran.HafalanAyatRepository
import com.acalapatih.ayatify.core.domain.usecase.hafalanquran.HafalanAyatUsecase
import kotlinx.coroutines.flow.Flow

class HafalanAyatInteractor(
    private val repository: HafalanAyatRepository
): HafalanAyatUsecase {
    override fun getAyat(nomorSurat: String, nomorAyat: String): Flow<Resource<HafalanAyatModel>> =
        repository.getAyat(nomorSurat, nomorAyat)
}