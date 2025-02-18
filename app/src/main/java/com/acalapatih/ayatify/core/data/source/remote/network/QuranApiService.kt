package com.acalapatih.ayatify.core.data.source.remote.network

import com.acalapatih.ayatify.core.data.source.remote.response.GetAyatResponse
import com.acalapatih.ayatify.core.data.source.remote.response.GetJuzResponse
import com.acalapatih.ayatify.core.data.source.remote.response.GetListAyatResponse
import com.acalapatih.ayatify.core.data.source.remote.response.GetListSuratResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranApiService {

    @GET("surah")
    suspend fun getListSurat(): GetListSuratResponse

    @GET("surah/{nomorSurah}")
    suspend fun getListAyatSurat(
        @Path("nomorSurah") nomorSurah: String
    ): GetListAyatResponse

    @GET("surah/{nomorSurah}/{nomorAyat}")
    suspend fun getAyat(
        @Path("nomorSurah") nomorSurah: String,
        @Path("nomorAyat") nomorAyat: String
    ): GetAyatResponse

    @GET("juz/{nomorJuz}")
    suspend fun getListAyatJuz(
        @Path("nomorJuz") nomorJuz: String
    ): GetJuzResponse
}