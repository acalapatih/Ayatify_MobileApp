package com.acalapatih.ayatify.core.data.repositoryImpl.bacaquran

import com.acalapatih.ayatify.core.data.NetworkOnlyResource
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.data.source.remote.RemoteDataSource
import com.acalapatih.ayatify.core.data.source.remote.network.ApiResponse
import com.acalapatih.ayatify.core.data.source.remote.response.GetAyatResponse
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaAyatModel
import com.acalapatih.ayatify.core.domain.repository.bacaquran.BacaAyatRepository
import kotlinx.coroutines.flow.Flow

class BacaAyatRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): BacaAyatRepository {
    override fun getAyat(nomorSurat: String, nomorAyat: String): Flow<Resource<BacaAyatModel>> =
        object : NetworkOnlyResource<BacaAyatModel, GetAyatResponse>() {
            override fun loadFromNetwork(data: GetAyatResponse): Flow<BacaAyatModel> =
                BacaAyatModel.mapResponseToModel(data)

            override suspend fun createCall(): Flow<ApiResponse<GetAyatResponse>> =
                remoteDataSource.getAyat(nomorSurat, nomorAyat)
        }.asFlow()
}