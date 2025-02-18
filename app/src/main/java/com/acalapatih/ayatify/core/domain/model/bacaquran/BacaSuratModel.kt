package com.acalapatih.ayatify.core.domain.model.bacaquran

import com.acalapatih.ayatify.core.data.source.remote.response.GetListAyatResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class BacaSuratModel(
    val nomorSurat: String,
    val namaSurat: String,
    val artiSurat: String,
    val jumlahAyat: String,
    val listAyat: List<GetListAyat>
) {
    data class GetListAyat(
        val nomorAyat: String,
        val lafadzAyat: String,
        val terjemahanAyat: String,
        val audioAyat: String
    ) {
        companion object{
            fun mapResponseToModel(response: GetListAyatResponse): Flow<BacaSuratModel> {
                return flowOf(
                    BacaSuratModel(
                        nomorSurat = response.data?.number.toString(),
                        namaSurat = response.data?.name?.transliteration?.id ?: "",
                        artiSurat = response.data?.name?.translation?.id ?: "",
                        jumlahAyat = response.data?.numberOfVerses.toString(),
                        listAyat = response.data?.verses?.map {
                            GetListAyat(
                                nomorAyat = it?.number?.inSurah.toString(),
                                lafadzAyat = it?.text?.arab ?: "",
                                terjemahanAyat = it?.translation?.id ?: "",
                                audioAyat = it?.audio?.primary ?: ""
                            )
                        } ?: emptyList()
                    )
                )
            }
        }
    }
}
