package com.acalapatih.ayatify.core.domain.usecase.hafalanquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanSuratModel
import kotlinx.coroutines.flow.Flow

interface HafalanSuratUseCase {
    fun getListAyat(nomorSurat: String): Flow<Resource<HafalanSuratModel>>
}