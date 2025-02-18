package com.acalapatih.ayatify.core.domain.repository.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.ListSuratModel
import kotlinx.coroutines.flow.Flow

interface ListSuratRepository {
    fun getListSurat(): Flow<Resource<ListSuratModel>>
}