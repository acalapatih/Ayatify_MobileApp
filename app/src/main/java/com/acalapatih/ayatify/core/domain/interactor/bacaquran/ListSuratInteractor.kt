package com.acalapatih.ayatify.core.domain.interactor.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.ListSuratModel
import com.acalapatih.ayatify.core.domain.repository.bacaquran.ListSuratRepository
import com.acalapatih.ayatify.core.domain.usecase.bacaquran.BacaQuranUsecase
import kotlinx.coroutines.flow.Flow

class ListSuratInteractor(
    private val repository: ListSuratRepository
): BacaQuranUsecase {
    override fun getListSurat(): Flow<Resource<ListSuratModel>> =
        repository.getListSurat()
}