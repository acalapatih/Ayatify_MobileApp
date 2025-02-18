package com.acalapatih.ayatify.core.domain.model.bacaquran

import com.acalapatih.ayatify.core.data.source.remote.response.GetListSuratResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class ListSuratModel(
    val listSurat: List<GetListSurat>
) {
    data class GetListSurat(
        val nomorSurat: String,
        val namaSurat: String,
        val artiSurat: String,
        val jumlahAyat: String
    ) {
        companion object {
            fun mapResponseToModel(response: GetListSuratResponse): Flow<ListSuratModel> {
                return flowOf(
                    ListSuratModel(
                        listSurat = response.data?.map {
                            GetListSurat(
                                nomorSurat = it?.number.toString(),
                                namaSurat = it?.name?.transliteration?.id ?: "",
                                artiSurat = it?.name?.translation?.id ?: "",
                                jumlahAyat = it?.numberOfVerses.toString()
                            )
                        } ?: emptyList()
                    )
                )
            }
        }
    }
}