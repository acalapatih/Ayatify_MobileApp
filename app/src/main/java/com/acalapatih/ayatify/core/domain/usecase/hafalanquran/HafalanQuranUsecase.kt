package com.acalapatih.ayatify.core.domain.usecase.hafalanquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanQuranModel
import kotlinx.coroutines.flow.Flow

interface HafalanQuranUsecase {
    fun getListSurat(): Flow<Resource<HafalanQuranModel>>
}