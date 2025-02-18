package com.acalapatih.ayatify.core.domain.repository.hafalanquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanAyatModel
import kotlinx.coroutines.flow.Flow

interface HafalanAyatRepository {
    fun getAyat(nomorSurat: String, nomorAyat: String): Flow<Resource<HafalanAyatModel>>
}