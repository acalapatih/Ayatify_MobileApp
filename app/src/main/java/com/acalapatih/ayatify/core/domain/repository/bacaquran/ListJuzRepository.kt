package com.acalapatih.ayatify.core.domain.repository.bacaquran

import androidx.lifecycle.LiveData
import com.acalapatih.ayatify.core.data.source.local.data.DataJuzQuran
import com.acalapatih.ayatify.core.data.source.local.entity.JuzQuran
import com.acalapatih.ayatify.core.data.source.local.room.dao.ListJuzDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListJuzRepository(
    private val bacaJuzDAO: ListJuzDAO
) {
    val allListJuz: LiveData<List<JuzQuran>> = bacaJuzDAO.getAllJuzQuran()

    fun initializeDummyData() {
        val dummyData = createDummyData()
        GlobalScope.launch(Dispatchers.IO) {
            bacaJuzDAO.insertAll(dummyData)
        }
    }

    private fun createDummyData(): List<JuzQuran> {
        val dummyListJuz = mutableListOf<JuzQuran>()
        DataJuzQuran.nomorJuzList.forEachIndexed { index, idJuz ->
            dummyListJuz.add(JuzQuran(idJuz, DataJuzQuran.nomorJuzList[index], DataJuzQuran.namaJuzList[index], DataJuzQuran.infoJuzList[index]))
        }
        return dummyListJuz
    }
}