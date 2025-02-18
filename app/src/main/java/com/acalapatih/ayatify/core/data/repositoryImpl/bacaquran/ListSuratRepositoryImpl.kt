package com.acalapatih.ayatify.core.data.repositoryImpl.bacaquran

import com.acalapatih.ayatify.core.data.NetworkOnlyResource
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.data.source.remote.RemoteDataSource
import com.acalapatih.ayatify.core.data.source.remote.network.ApiResponse
import com.acalapatih.ayatify.core.data.source.remote.response.GetListSuratResponse
import com.acalapatih.ayatify.core.domain.model.bacaquran.ListSuratModel
import com.acalapatih.ayatify.core.domain.repository.bacaquran.ListSuratRepository
import kotlinx.coroutines.flow.Flow

class ListSuratRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): ListSuratRepository {
    override fun getListSurat(): Flow<Resource<ListSuratModel>> =
        object : NetworkOnlyResource<ListSuratModel, GetListSuratResponse>() {
            override fun loadFromNetwork(data: GetListSuratResponse): Flow<ListSuratModel> =
                ListSuratModel.GetListSurat.mapResponseToModel(data)

            override suspend fun createCall(): Flow<ApiResponse<GetListSuratResponse>> =
                remoteDataSource.getListSurah()
        }.asFlow()

}