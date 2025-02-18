package com.acalapatih.ayatify.core.domain.repository.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaAyatModel
import kotlinx.coroutines.flow.Flow

interface BacaAyatRepository {
    fun getAyat(nomorSurat: String, nomorAyat: String): Flow<Resource<BacaAyatModel>>
}