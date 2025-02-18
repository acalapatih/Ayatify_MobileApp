package com.acalapatih.ayatify.core.domain.usecase.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaSuratModel
import kotlinx.coroutines.flow.Flow

interface BacaSuratUsecase {
    fun getListAyatSurat(nomorSurat: String): Flow<Resource<BacaSuratModel>>
}