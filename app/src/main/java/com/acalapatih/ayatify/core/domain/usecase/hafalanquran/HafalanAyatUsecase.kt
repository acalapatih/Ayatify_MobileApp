package com.acalapatih.ayatify.core.domain.usecase.hafalanquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanAyatModel
import kotlinx.coroutines.flow.Flow

interface HafalanAyatUsecase {
    fun getAyat(nomorSurat: String, nomorAyat: String): Flow<Resource<HafalanAyatModel>>
}