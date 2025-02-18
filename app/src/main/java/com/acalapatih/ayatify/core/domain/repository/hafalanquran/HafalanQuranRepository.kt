package com.acalapatih.ayatify.core.domain.repository.hafalanquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanQuranModel
import kotlinx.coroutines.flow.Flow

interface HafalanQuranRepository {
    fun getListSurat(): Flow<Resource<HafalanQuranModel>>
}