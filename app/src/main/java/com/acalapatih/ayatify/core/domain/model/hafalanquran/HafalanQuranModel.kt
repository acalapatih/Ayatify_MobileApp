package com.acalapatih.ayatify.core.domain.model.hafalanquran

import com.acalapatih.ayatify.core.data.source.remote.response.GetListSuratResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HafalanQuranModel(
    val listSurat: List<GetListSurat>
) {
    data class GetListSurat(
        val nomorSurat: String,
        val namaSurat: String,
        val jumlahAyat: String
    ) {
        companion object {
            fun mapResponseToModel(response: GetListSuratResponse): Flow<HafalanQuranModel> {
                return flowOf(
                    HafalanQuranModel(
                        listSurat = response.data?.map {
                            GetListSurat(
                                nomorSurat = it?.number.toString(),
                                namaSurat = it?.name?.transliteration?.id ?: "",
                                jumlahAyat = it?.numberOfVerses.toString()
                            )
                        } ?: emptyList()
                    )
                )
            }
        }
    }
}
