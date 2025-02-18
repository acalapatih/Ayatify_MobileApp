package com.acalapatih.ayatify.core.domain.repository.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaSuratModel
import kotlinx.coroutines.flow.Flow

interface BacaSuratRepository {
    fun getListAyatSurat(nomorSurat: String): Flow<Resource<BacaSuratModel>>
}