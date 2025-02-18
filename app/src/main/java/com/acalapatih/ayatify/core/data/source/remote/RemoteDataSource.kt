package com.acalapatih.ayatify.core.data.source.remote

import com.acalapatih.ayatify.core.data.source.remote.network.ApiResponse
import com.acalapatih.ayatify.core.data.source.remote.network.QuranApiService
import com.acalapatih.ayatify.core.data.source.remote.response.*
import com.acalapatih.ayatify.utils.setGeneralError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(
    private val quranApiService: QuranApiService,
) {
    suspend fun getListSurah(): Flow<ApiResponse<GetListSuratResponse>> {
        return flow {
            try {
                val response = quranApiService.getListSurat()

                if (response.code == 200) {
                    emit(ApiResponse.Success(response))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.setGeneralError()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getListAyatSurat(nomorSurat: String): Flow<ApiResponse<GetListAyatResponse>> {
        return flow {
            try {
                val response = quranApiService.getListAyatSurat(nomorSurat)

                if (response.code == 200) {
                    emit(ApiResponse.Success(response))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.setGeneralError()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getListAyatJuz(nomorJuz: String): Flow<ApiResponse<GetJuzResponse>> {
        return flow {
            try {
                val response = quranApiService.getListAyatJuz(nomorJuz)

                if (response.code == 200) {
                    emit(ApiResponse.Success(response))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.setGeneralError()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAyat(nomorSurat: String, nomorAyat: String): Flow<ApiResponse<GetAyatResponse>> {
        return flow {
            try {
                val response = quranApiService.getAyat(nomorSurat, nomorAyat)

                if (response.code == 200) {
                    emit(ApiResponse.Success(response))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.setGeneralError()))
            }
        }.flowOn(Dispatchers.IO)
    }
}