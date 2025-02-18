package com.acalapatih.ayatify.core.domain.usecase.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.ListSuratModel
import kotlinx.coroutines.flow.Flow

interface BacaQuranUsecase {
    fun getListSurat(): Flow<Resource<ListSuratModel>>
}