package com.acalapatih.ayatify.core.domain.model.hafalanquran

import com.acalapatih.ayatify.core.data.source.remote.response.GetListAyatResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HafalanSuratModel(
    val nomorSurat: String,
    val namaSurat: String,
    val jumlahAyat: String,
    val listAyat: List<GetListAyat>
) {
    data class GetListAyat(
        val nomorAyat: String,
        val lafadzAyat: String
    ) {
        companion object{
            fun mapResponseToModel(response: GetListAyatResponse): Flow<HafalanSuratModel> {
                return flowOf(
                    HafalanSuratModel(
                        nomorSurat = response.data?.number.toString(),
                        namaSurat = response.data?.name?.transliteration?.id ?: "",
                        jumlahAyat = response.data?.numberOfVerses.toString(),
                        listAyat = response.data?.verses?.map {
                            GetListAyat(
                                nomorAyat = it?.number?.inSurah.toString(),
                                lafadzAyat = it?.text?.arab ?: ""
                            )
                        } ?: emptyList()
                    )
                )
            }
        }
    }
}