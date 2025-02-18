package com.acalapatih.ayatify.core.domain.usecase.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaJuzModel
import kotlinx.coroutines.flow.Flow

interface BacaJuzUsecase {
    fun getListAyatJuz(nomorJuz: String): Flow<Resource<BacaJuzModel>>
}