package com.acalapatih.ayatify.core.domain.model.hafalanquran

import com.acalapatih.ayatify.core.data.source.remote.response.GetAyatResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HafalanAyatModel(
    val namaSurat: String,
    val nomorAyat: String,
    val lafadzAyat: String,
    val audioAyat: String
) {
    companion object{
        fun mapResponseToModel(response: GetAyatResponse): Flow<HafalanAyatModel> {
            return flowOf(
                HafalanAyatModel(
                    namaSurat = response.data?.surah?.name?.transliteration?.id ?: "",
                    nomorAyat = response.data?.number?.inSurah.toString(),
                    lafadzAyat = response.data?.text?.arab ?: "",
                    audioAyat = response.data?.audio?.primary ?: ""
                )
            )
        }
    }
}