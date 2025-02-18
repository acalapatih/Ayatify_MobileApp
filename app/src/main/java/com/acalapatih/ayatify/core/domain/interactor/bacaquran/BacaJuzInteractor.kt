package com.acalapatih.ayatify.core.domain.interactor.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaJuzModel
import com.acalapatih.ayatify.core.domain.repository.bacaquran.BacaJuzRepository
import com.acalapatih.ayatify.core.domain.usecase.bacaquran.BacaJuzUsecase
import kotlinx.coroutines.flow.Flow

class BacaJuzInteractor(
    private val repository: BacaJuzRepository
): BacaJuzUsecase {
    override fun getListAyatJuz(nomorJuz: String): Flow<Resource<BacaJuzModel>> =
        repository.getListAyatJuz(nomorJuz)
}