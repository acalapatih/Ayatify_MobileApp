package com.acalapatih.ayatify.core.domain.interactor.bacaquran

import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaSuratModel
import com.acalapatih.ayatify.core.domain.repository.bacaquran.BacaSuratRepository
import com.acalapatih.ayatify.core.domain.usecase.bacaquran.BacaSuratUsecase
import kotlinx.coroutines.flow.Flow

class BacaSuratInteractor(
    private val repository: BacaSuratRepository
): BacaSuratUsecase {
    override fun getListAyatSurat(nomorSurat: String): Flow<Resource<BacaSuratModel>> =
        repository.getListAyatSurat(nomorSurat)
}