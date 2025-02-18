package com.acalapatih.ayatify.core.data.repositoryImpl.hafalanquran

import com.acalapatih.ayatify.core.data.NetworkOnlyResource
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.data.source.remote.RemoteDataSource
import com.acalapatih.ayatify.core.data.source.remote.network.ApiResponse
import com.acalapatih.ayatify.core.data.source.remote.response.GetListAyatResponse
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanSuratModel
import com.acalapatih.ayatify.core.domain.repository.hafalanquran.HafalanSuratRepository
import kotlinx.coroutines.flow.Flow

class HafalanSuratRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
): HafalanSuratRepository {
    override fun getListAyat(nomorSurat: String): Flow<Resource<HafalanSuratModel>> =
        object : NetworkOnlyResource<HafalanSuratModel, GetListAyatResponse>() {
            override fun loadFromNetwork(data: GetListAyatResponse): Flow<HafalanSuratModel> =
                HafalanSuratModel.GetListAyat.mapResponseToModel(data)

            override suspend fun createCall(): Flow<ApiResponse<GetListAyatResponse>> =
                remoteDataSource.getListAyatSurat(nomorSurat)
        }.asFlow()
}