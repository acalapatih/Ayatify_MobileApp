package com.acalapatih.ayatify.core.domain.interactor.hafalanquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanQuranModel
import com.acalapatih.ayatify.core.domain.repository.hafalanquran.HafalanQuranRepository
import com.acalapatih.ayatify.core.domain.usecase.hafalanquran.HafalanQuranUsecase
import kotlinx.coroutines.flow.Flow

class HafalanQuranInteractor(
    private val repository: HafalanQuranRepository
) : HafalanQuranUsecase {
    override fun getListSurat(): Flow<Resource<HafalanQuranModel>> =
        repository.getListSurat()
}