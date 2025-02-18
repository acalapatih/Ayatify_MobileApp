package com.acalapatih.ayatify.core.domain.repository.bookmark

import android.app.Application
import com.acalapatih.ayatify.core.data.source.local.entity.AyatDihafal
import com.acalapatih.ayatify.core.data.source.local.room.dao.AyatDihafalDAO
import com.acalapatih.ayatify.core.data.source.local.room.database.AyatDihafalDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class AyatDihafalRepository(application: Application) {
    private val ayatDihafalDAO: AyatDihafalDAO
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = AyatDihafalDatabase.getDatabase(application)
        ayatDihafalDAO = db.ayatDihafalDao()
    }

    fun insertAyatDihafal(ayatDihafal: AyatDihafal) {
        executorService.execute { ayatDihafalDAO.insertAyatDihafal(ayatDihafal) }
    }

    fun getAyatDihafal() = ayatDihafalDAO.getAyatDihafal()

    fun getWaktuHafalan() = ayatDihafalDAO.getWaktuHafalan()

    fun getJumlahAyatDihafal() = ayatDihafalDAO.getJumlahAyatDihafal()
}