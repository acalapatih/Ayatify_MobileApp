package com.acalapatih.ayatify.core.domain.model.bacaquran

import com.acalapatih.ayatify.core.data.source.remote.response.GetJuzResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class BacaJuzModel(
    val nomorJuz: String,
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
            fun mapResponseToModel(response: GetJuzResponse): Flow<BacaJuzModel> {
                return flowOf(
                    BacaJuzModel(
                        nomorJuz = response.data?.juz.toString(),
                        jumlahAyat = response.data?.totalVerses.toString(),
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