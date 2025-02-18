package com.acalapatih.ayatify.core.domain.repository.bookmark

import android.app.Application
import com.acalapatih.ayatify.core.data.source.local.room.dao.AyatFavoritDAO
import com.acalapatih.ayatify.core.data.source.local.room.database.AyatFavoritDatabase
import com.acalapatih.ayatify.core.data.source.local.entity.AyatFavorit
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class AyatFavoritRepository(application: Application) {
    private val ayatFavoritDAO: AyatFavoritDAO
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = AyatFavoritDatabase.getDatabase(application)
        ayatFavoritDAO = db.ayatFavoritDao()
    }

    fun insert(ayatFavorit: AyatFavorit) {
        executorService.execute { ayatFavoritDAO.insert(ayatFavorit) }
    }

    fun delete(ayatFavorit: AyatFavorit) {
        executorService.execute { ayatFavoritDAO.delete(ayatFavorit) }
    }

    fun getAllAyatFavorit() = ayatFavoritDAO.getAllAyatFavorit()
}