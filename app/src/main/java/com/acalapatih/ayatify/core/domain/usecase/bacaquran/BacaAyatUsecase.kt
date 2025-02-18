package com.acalapatih.ayatify.core.domain.usecase.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaAyatModel
import kotlinx.coroutines.flow.Flow

interface BacaAyatUsecase {
    fun getAyat(nomorSurat: String, nomorAyat: String): Flow<Resource<BacaAyatModel>>
}