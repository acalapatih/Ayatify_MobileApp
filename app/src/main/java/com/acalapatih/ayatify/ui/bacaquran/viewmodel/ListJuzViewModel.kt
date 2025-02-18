package com.acalapatih.ayatify.ui.bacaquran.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.acalapatih.ayatify.core.data.source.local.entity.JuzQuran
import com.acalapatih.ayatify.core.data.source.local.room.database.ListJuzDatabase
import com.acalapatih.ayatify.core.domain.repository.bacaquran.ListJuzRepository

class ListJuzViewModel(
    application: Application
): ViewModel() {
    private val repository: ListJuzRepository
    val allListJuz: LiveData<List<JuzQuran>>

    init {
        val bacaJuzDao = ListJuzDatabase.getDatabase(application).listJuzDAO()
        repository = ListJuzRepository(bacaJuzDao)
        allListJuz = repository.allListJuz

        repository.initializeDummyData()
    }
}