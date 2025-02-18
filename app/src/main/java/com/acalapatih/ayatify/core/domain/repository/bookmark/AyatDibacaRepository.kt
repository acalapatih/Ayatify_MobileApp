package com.acalapatih.ayatify.core.domain.repository.bookmark

import android.app.Application
import androidx.lifecycle.LiveData
import com.acalapatih.ayatify.core.data.source.local.entity.AyatDibaca
import com.acalapatih.ayatify.core.data.source.local.room.dao.AyatDibacaDAO
import com.acalapatih.ayatify.core.data.source.local.room.database.AyatDibacaDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class AyatDibacaRepository(application: Application) {
    private val ayatDibacaDAO: AyatDibacaDAO
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = AyatDibacaDatabase.getDatabase(application)
        ayatDibacaDAO = db.ayatDibacaDao()
    }

    fun insert(ayatDibaca: AyatDibaca) {
        executorService.execute { ayatDibacaDAO.insert(ayatDibaca) }
    }

    fun delete(ayatDibaca: AyatDibaca) {
        executorService.execute { ayatDibacaDAO.delete(ayatDibaca) }
    }

    fun getAyatDibaca(): LiveData<AyatDibaca> = ayatDibacaDAO.getAyatDibaca()
}