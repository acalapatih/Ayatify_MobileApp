package com.acalapatih.ayatify.core.domain.repository.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaJuzModel
import kotlinx.coroutines.flow.Flow

interface BacaJuzRepository {
    fun getListAyatJuz(nomorJuz: String): Flow<Resource<BacaJuzModel>>
}