package com.acalapatih.ayatify.ui.bacaquran.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.acalapatih.ayatify.BaseActivity
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.data.source.local.entity.AyatDibaca
import com.acalapatih.ayatify.core.domain.model.bacaquran.BacaSuratModel
import com.acalapatih.ayatify.core.factory.SettingViewModelFactory
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import com.acalapatih.ayatify.databinding.ActivityBacaSuratBinding
import com.acalapatih.ayatify.ui.bacaquran.adapter.BacaSuratAdapter
import com.acalapatih.ayatify.ui.bacaquran.viewmodel.BacaSuratViewModel
import com.acalapatih.ayatify.ui.bookmark.activity.BookmarkActivity
import com.acalapatih.ayatify.ui.setting.SettingViewModel
import com.acalapatih.ayatify.utils.Const.NOMOR_SURAT
import com.acalapatih.ayatify.utils.dataStore
import org.koin.androidx.viewmodel.ext.android.viewModel

class BacaSuratActivity : BaseActivity<ActivityBacaSuratBinding>(), BacaSuratAdapter.OnUserClickListener {

    private val viewModel by viewModel<BacaSuratViewModel>()
    private lateinit var bacaSuratAdapter: BacaSuratAdapter
    private val nomorSurat by lazy { intent.getStringExtra(NOMOR_SURAT) }

    override fun getViewBinding(): ActivityBacaSuratBinding =
        ActivityBacaSuratBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        nomorSurat?.let { viewModel.getListAyat(it) }

        initView()
        initObserver()
        initListener()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this@BacaSuratActivity)
        val itemDecoration = DividerItemDecoration(this@BacaSuratActivity, layoutManager.orientation)
        with(binding.rvAyat) {
            setLayoutManager(layoutManager)
            addItemDecoration(itemDecoration)
        }
    }

    private fun initObserver() {
        viewModel.getListAyat.observe(this) { model ->
            when (model) {
                is Resource.Loading -> {
                    showLoading(true)
                    binding.imgHeaderBacaQuran.visibility = View.GONE
                }
                is Resource.Success -> {
                    showLoading(false)
                    model.data?.let { data ->
                        getListAyat(data)
                        binding.imgHeaderBacaQuran.visibility = View.VISIBLE
                    }
                }
                is Resource.Error -> {
                    showLoading(false)
                    model.message?.let {
                        println(it)
                        Toast.makeText(
                            this@BacaSuratActivity,
                            it,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun showLoading(value: Boolean) {
        binding.progressBar.isVisible = value
    }

    @SuppressLint("SetTextI18n")
    private fun getListAyat(data: BacaSuratModel) {
        val pengaturanPref = SettingPreferences.getInstance(dataStore)
        val settingViewModel = ViewModelProvider(
            this,
            SettingViewModelFactory(pengaturanPref)
        )[SettingViewModel::class.java]
        val listener = this

        settingViewModel.getThemeSetting().observe(this@BacaSuratActivity) { isDarkModeActive: Boolean ->
            with(binding) {
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    icBack.setImageResource(R.drawable.ic_back_dark)
                    icBookmark.setImageResource(R.drawable.ic_bookmark_dark)
                    imgHeaderBacaQuran.setImageResource(R.drawable.bg_header_bacaquran_dark)
                    cvAudioAyat.backgroundTintList = ContextCompat.getColorStateList(this@BacaSuratActivity, R.color.blue_001C30)
                    bacaSuratAdapter = BacaSuratAdapter(
                        this@BacaSuratActivity,
                        data.namaSurat,
                        data.nomorSurat,
                        data.listAyat,
                        isDarkModeActive,
                        listener
                    )
                    tvSurat.text = data.namaSurat
                    tvInfoSurat.text = "${data.artiSurat} | ${data.jumlahAyat} Ayat"
                    rvAyat.adapter = bacaSuratAdapter

                    bacaSuratAdapter.ayatFavoritSelected = { ayatFavorit, nomorAyat, icFavorit ->
                        showDialogAyatFavorit {
                            viewModel.insertAyatFavorit(ayatFavorit)
                        }
                    }
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    icBack.setImageResource(R.drawable.ic_back_light)
                    icBookmark.setImageResource(R.drawable.ic_bookmark_light)
                    imgHeaderBacaQuran.setImageResource(R.drawable.bg_header_bacaquran_light)
                    cvAudioAyat.backgroundTintList = ContextCompat.getColorStateList(this@BacaSuratActivity, R.color.white)
                    bacaSuratAdapter = BacaSuratAdapter(
                        this@BacaSuratActivity,
                        data.namaSurat,
                        data.nomorSurat,
                        data.listAyat,
                        isDarkModeActive,
                        listener
                    )
                    tvSurat.text = data.namaSurat
                    tvInfoSurat.text = "${data.artiSurat} | ${data.jumlahAyat} Ayat"
                    rvAyat.adapter = bacaSuratAdapter

                    bacaSuratAdapter.ayatFavoritSelected = { ayatFavorit, nomorAyat, icFavorit ->
                        showDialogAyatFavorit {
                            viewModel.insertAyatFavorit(ayatFavorit)
                        }
                    }
                }
            }
        }
    }

    private fun initListener() {
        with(binding) {
            icBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            onBackPressedDispatcher.addCallback(this@BacaSuratActivity) {
                finish()
            }

            icBookmark.setOnClickListener {
                BookmarkActivity.start(this@BacaSuratActivity)
            }
        }
    }

    override fun onUserClickedTandai(ayatDibaca: AyatDibaca, clicked: String) {
        showDialogTerakhirDibaca {
            viewModel.insertAyatDibaca(ayatDibaca)
        }
    }

    override fun onUserClickedAudio(nomorAyat: String, audioAyatPlayer: MediaPlayer, clicked: String) {
        nomorSurat?.let { viewModel.getAyat(it, nomorAyat) }
        initObserverAudioAyat(audioAyatPlayer)
    }

    @SuppressLint("SetTextI18n")
    private fun initObserverAudioAyat(audioAyatPlayer: MediaPlayer) {
        viewModel.getAyat.observe(this) { model ->
            when (model) {
                is Resource.Loading -> {
                    showLoading(true)
                }
                is Resource.Success -> {
                    showLoading(false)
                    model.data?.let { data ->
                        with(binding) {
                            binding.cvAudioAyat.isVisible = true
                            binding.tvAudioAyat.text = "${data.namaSurat} : ${data.nomorAyat}"
                            icPlay.alpha = 0.5F
                            icPlay.isEnabled = false

                            icPause.setOnClickListener {
                                audioAyatPlayer.pause()

                                icPause.alpha = 0.5F
                                icPause.isEnabled = false

                                icPlay.alpha = 1F
                                icPlay.isEnabled = true
                            }

                            icReset.setOnClickListener {
                                if (audioAyatPlayer.isPlaying) {
                                    audioAyatPlayer.pause()
                                }

                                audioAyatPlayer.reset()
                                audioAyatPlayer.setDataSource(this@BacaSuratActivity, data.audioAyat.toUri())
                                audioAyatPlayer.prepare()

                                icPlay.alpha = 1F
                                icPlay.isEnabled = true

                                icPause.alpha = 0.5F
                                icPause.isEnabled = false
                            }

                            icPlay.setOnClickListener {
                                audioAyatPlayer.start()
                                icPlay.alpha = 0.5F
                                icPlay.isEnabled = false

                                icPause.alpha = 1F
                                icPause.isEnabled = true
                            }

                            btnStop.setOnClickListener {
                                audioAyatPlayer.stop()
                                audioAyatPlayer.release()
                                cvAudioAyat.isVisible = false
                            }
                        }
                    }
                }
                is Resource.Error -> {
                    showLoading(false)
                    model.message?.let {
                        println(it)
                        showToast(
                            it, Toast.LENGTH_SHORT
                        )
                    }
                }
            }
        }
    }

    companion object {
        fun start(context: Context, nomorSurat: String) {
            val starter = Intent(context, BacaSuratActivity::class.java)
                .putExtra(NOMOR_SURAT,  nomorSurat)
            context.startActivity(starter)
        }
    }
}