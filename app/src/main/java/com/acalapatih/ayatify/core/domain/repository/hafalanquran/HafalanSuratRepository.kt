package com.acalapatih.ayatify.core.domain.repository.hafalanquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanSuratModel
import kotlinx.coroutines.flow.Flow

interface HafalanSuratRepository {
    fun getListAyat(nomorSurat: String): Flow<Resource<HafalanSuratModel>>
}