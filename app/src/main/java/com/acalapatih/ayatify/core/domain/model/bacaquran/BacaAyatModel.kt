package com.acalapatih.ayatify.core.domain.model.bacaquran

import com.acalapatih.ayatify.core.data.source.remote.response.GetAyatResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class BacaAyatModel(
    val nomorSurat: String,
    val namaSurat: String,
    val nomorAyat: String,
    val audioAyat: String
) {
    companion object {
        fun mapResponseToModel(response: GetAyatResponse): Flow<BacaAyatModel> {
            return flowOf(
                BacaAyatModel(
                    nomorSurat = response.data?.surah?.number.toString(),
                    namaSurat = response.data?.surah?.name?.transliteration?.id ?: "",
                    nomorAyat = response.data?.number?.inSurah.toString(),
                    audioAyat = response.data?.audio?.primary ?: ""
                )
            )
        }
    }
}