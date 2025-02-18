package com.acalapatih.ayatify.ui.bookmark.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.acalapatih.ayatify.BaseActivity
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.core.factory.SettingViewModelFactory
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import com.acalapatih.ayatify.databinding.ActivityBookmarkBinding
import com.acalapatih.ayatify.ui.bookmark.adapter.BookmarkAdapter
import com.acalapatih.ayatify.ui.bookmark.viewmodel.BookmarkViewModel
import com.acalapatih.ayatify.ui.setting.SettingViewModel
import com.acalapatih.ayatify.utils.dataStore
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarkActivity : BaseActivity<ActivityBookmarkBinding>() {

    private val viewModel by viewModel<BookmarkViewModel>()
    private lateinit var bookmarkAdapter: BookmarkAdapter

    override fun getViewBinding(): ActivityBookmarkBinding =
        ActivityBookmarkBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        initView()
        initListener()
    }

    private fun initView() {
        val pengaturanPref = SettingPreferences.getInstance(dataStore)
        val settingViewModel = ViewModelProvider(
            this,
            SettingViewModelFactory(pengaturanPref)
        )[SettingViewModel::class.java]

        settingViewModel.getThemeSetting().observe(this@BookmarkActivity) { isDarkModeActive: Boolean ->
            with(binding) {
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    icBack.setImageResource(R.drawable.ic_back_dark)
                    icTerakhirDibaca.setImageResource(R.drawable.ic_dibaca_dark)
                    icAyatFavorit.setImageResource(R.drawable.ic_ayat_favorit_dark)

                    bookmarkAdapter = BookmarkAdapter(isDarkModeActive)
                    val layoutManager = LinearLayoutManager(this@BookmarkActivity)
                    val itemDecoration = DividerItemDecoration(this@BookmarkActivity, layoutManager.orientation)
                    with(binding.rvAyat) {
                        setLayoutManager(layoutManager)
                        addItemDecoration(itemDecoration)
                        adapter = bookmarkAdapter
                    }
                    initObserver(isDarkModeActive)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    icBack.setImageResource(R.drawable.ic_back_light)
                    icTerakhirDibaca.setImageResource(R.drawable.ic_dibaca_light)
                    icAyatFavorit.setImageResource(R.drawable.ic_ayat_favorit_light)

                    bookmarkAdapter = BookmarkAdapter(isDarkModeActive)
                    val layoutManager = LinearLayoutManager(this@BookmarkActivity)
                    val itemDecoration = DividerItemDecoration(this@BookmarkActivity, layoutManager.orientation)
                    with(binding.rvAyat) {
                        setLayoutManager(layoutManager)
                        addItemDecoration(itemDecoration)
                        adapter = bookmarkAdapter
                    }
                    initObserver(isDarkModeActive)
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initObserver(isDarkMode: Boolean) {
        viewModel.ayatDibaca.observe(this) { data ->
            if (data != null) {
                with(binding.tvAyatDibaca) {
                    text = "Q.S ${data.namaSurat} : ${data.nomorAyat}"

                    setOnClickListener {
                        AyatDisimpan.start(this@BookmarkActivity, data.nomorSurat, data.nomorAyat)
                    }
                }
            } else {
                binding.tvAyatDibaca.text = "Belum ada ayat yang ditandai"
            }
        }

        viewModel.getAllAyatFavorit().observe(this) { listAyatFavorit ->
            if (listAyatFavorit != null) {
                bookmarkAdapter.setListFavorite(listAyatFavorit)

                bookmarkAdapter.lihatAyatFavorit = { ayatFavorit ->
                    ayatFavorit.namaSurat?.let {
                        showDialogItemAyatFavorit(
                            it,
                            ayatFavorit.nomorAyat,
                            ayatFavorit.lafadzAyat,
                            ayatFavorit.terjemahanAyat,
                            isDarkMode
                        )
                    }
                }

                bookmarkAdapter.hapusAyatFavorit = { ayatFavorit ->
                    showDialogHapusAyatFavorit {
                        viewModel.delete(ayatFavorit)
                    }
                }
            } else {
                binding.tvNoDataAyatFavorit.isVisible = true
            }
        }
    }

    private fun initListener() {
        with(binding) {
            icBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            onBackPressedDispatcher.addCallback(this@BookmarkActivity) {
                finish()
            }
        }
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, BookmarkActivity::class.java)
            context.startActivity(starter)
        }
    }
}