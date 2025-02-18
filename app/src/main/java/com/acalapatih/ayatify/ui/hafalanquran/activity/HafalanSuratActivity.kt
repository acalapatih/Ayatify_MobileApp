package com.acalapatih.ayatify.ui.hafalanquran.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanSuratModel
import com.acalapatih.ayatify.databinding.ActivityHafalanSuratBinding
import com.acalapatih.ayatify.ui.bookmark.activity.BookmarkActivity
import com.acalapatih.ayatify.ui.hafalanquran.adapter.HafalanSuratAdapter
import com.acalapatih.ayatify.ui.hafalanquran.viewmodel.HafalanSuratViewModel
import com.acalapatih.ayatify.BaseActivity
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.core.factory.SettingViewModelFactory
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import com.acalapatih.ayatify.ui.setting.SettingViewModel
import com.acalapatih.ayatify.utils.Const.NOMOR_SURAT
import com.acalapatih.ayatify.utils.dataStore
import org.koin.androidx.viewmodel.ext.android.viewModel

class HafalanSuratActivity : BaseActivity<ActivityHafalanSuratBinding>(), HafalanSuratAdapter.OnUserClickListener {

    private lateinit var hafalanSuratAdapter: HafalanSuratAdapter
    private val viewModel by viewModel<HafalanSuratViewModel>()
    private val nomorSurat by lazy { intent.getStringExtra(NOMOR_SURAT) }

    override fun getViewBinding(): ActivityHafalanSuratBinding =
        ActivityHafalanSuratBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        nomorSurat?.let { viewModel.getListAyat(it) }

        initView()
        initObserver()
        initListener()
    }

    private fun initView() {
        val pengaturanPref = SettingPreferences.getInstance(dataStore)
        val settingViewModel = ViewModelProvider(
            this,
            SettingViewModelFactory(pengaturanPref)
        )[SettingViewModel::class.java]

        settingViewModel.getThemeSetting().observe(this@HafalanSuratActivity) { isDarkModeActive: Boolean ->
            with(binding) {
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    icBack.setImageResource(R.drawable.ic_back_dark)
                    icBookmark.setImageResource(R.drawable.ic_bookmark_dark)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    icBack.setImageResource(R.drawable.ic_back_light)
                    icBookmark.setImageResource(R.drawable.ic_bookmark_light)
                }
            }
        }

        val layoutManager = LinearLayoutManager(this@HafalanSuratActivity)
        val itemDecoration = DividerItemDecoration(this@HafalanSuratActivity, layoutManager.orientation)
        with(binding.rvHafalanAyat) {
            setLayoutManager(layoutManager)
            addItemDecoration(itemDecoration)
        }
    }

    private fun initObserver() {
        viewModel.getListAyat.observe(this) { model ->
            when (model) {
                is Resource.Loading -> {
                    showLoading(true)
                }
                is Resource.Success -> {
                    showLoading(false)
                    model.data?.let { data ->
                        getListAyat(data)
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

    private fun showLoading(value: Boolean) {
        binding.progressBar.isVisible = value
    }

    private fun getListAyat(data: HafalanSuratModel) {
        if (data.namaSurat == "Al-Fatihah") {
            viewModel.getAllAlFatihah().observe(this) { alFatihah ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alFatihah.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "An-Nas") {
            viewModel.getAllAnNas().observe(this) { anNas ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, anNas.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Falaq") {
            viewModel.getAllAlFalaq().observe(this) { alFalaq ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alFalaq.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Ikhlas") {
            viewModel.getAllAlIkhlas().observe(this) { alIkhlas ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alIkhlas.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Lahab") {
            viewModel.getAllAlLahab().observe(this) { alLahab ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alLahab.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "An-Nasr") {
            viewModel.getAllAnNasr().observe(this) { anNasr ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, anNasr.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Kafirun") {
            viewModel.getAllAlKafirun().observe(this) { alKafirun ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alKafirun.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Kausar") {
            viewModel.getAllAlKausar().observe(this) { alKausar ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alKausar.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Ma'un") {
            viewModel.getAllAlMaun().observe(this) { alMaun ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alMaun.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Quraisy") {
            viewModel.getAllAlQuraisy().observe(this) { alQuraisy ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alQuraisy.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Fil") {
            viewModel.getAllAlFil().observe(this) { alFil ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alFil.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Humazah") {
            viewModel.getAllAlHumazah().observe(this) { alHumazah ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alHumazah.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-'Asr") {
            viewModel.getAllAlAsr().observe(this) { alAsr ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alAsr.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "At-Takasur") {
            viewModel.getAllAtTakasur().observe(this) { atTakasur ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, atTakasur.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Qari'ah") {
            viewModel.getAllAlQariah().observe(this) { alQariah ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alQariah.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-'Adiyat") {
            viewModel.getAllAlAdiyat().observe(this) { alAdiyat ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alAdiyat.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Zalzalah") {
            viewModel.getAllAlZalzalah().observe(this) { alZalzalah ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alZalzalah.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Bayyinah") {
            viewModel.getAllAlBayyinah().observe(this) { alBayyinah ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alBayyinah.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Qadr") {
            viewModel.getAllAlQadr().observe(this) { alQadr ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alQadr.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-'Alaq") {
            viewModel.getAllAlAlaq().observe(this) { alAlaq ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alAlaq.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "At-Tin") {
            viewModel.getAllAtTin().observe(this) { atTin ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, atTin.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Asy-Syarh") {
            viewModel.getAllAsySyarh().observe(this) { asySyarh ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, asySyarh.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Ad-Duha") {
            viewModel.getAllAdDuha().observe(this) { adDuha ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, adDuha.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Lail") {
            viewModel.getAllAlLail().observe(this) { alLail ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alLail.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Asy-Syam") {
            viewModel.getAllAsySyam().observe(this) { asySyam ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, asySyam.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Balad") {
            viewModel.getAllAlBalad().observe(this) { alBalad ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alBalad.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Fajr") {
            viewModel.getAllAlFajr().observe(this) { alFajr ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alFajr.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Gasyiyah") {
            viewModel.getAllAlGasyiyah().observe(this) { alGasyiyah ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alGasyiyah.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Ala'") {
            viewModel.getAllAlAla().observe(this) { alAla ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alAla.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "At-Tariq") {
            viewModel.getAllAtTariq().observe(this) { alTariq ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alTariq.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Buruj") {
            viewModel.getAllAlBuruj().observe(this) { alBuruj ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alBuruj.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Insyiqaq") {
            viewModel.getAllAlInsyiqaq().observe(this) { alInsyiqaq ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alInsyiqaq.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Mutaffifin") {
            viewModel.getAllAlMutaffifin().observe(this) { alMutaffifin ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alMutaffifin.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Infitar") {
            viewModel.getAllAlInfitar().observe(this) { alInfitar ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alInfitar.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "At-Takwir") {
            viewModel.getAllAtTakwir().observe(this) { atTakwir ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, atTakwir.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "'Abasa") {
            viewModel.getAllAbasa().observe(this) { abasa ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, abasa.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "An-Nazi'at") {
            viewModel.getAllAnNaziat().observe(this) { anNaziat ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, anNaziat.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "An-Naba'") {
            viewModel.getAllAnNaba().observe(this) { anNaba ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, anNaba.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        if (data.namaSurat == "Al-Mulk") {
            viewModel.getAllAlMulk().observe(this) { alMulk ->
                hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, alMulk.size + 1, this)
                with(binding) {
                    tvSurat.text = data.namaSurat
                    rvHafalanAyat.adapter = hafalanSuratAdapter
                }
            }
        }
        else {
            hafalanSuratAdapter = HafalanSuratAdapter(data.listAyat, 1, this)
            with(binding) {
                tvSurat.text = data.namaSurat
                rvHafalanAyat.adapter = hafalanSuratAdapter
            }
        }
    }

    private fun initListener() {
        with(binding) {
            icBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            onBackPressedDispatcher.addCallback {
                finish()
            }

            icBookmark.setOnClickListener {
                BookmarkActivity.start(this@HafalanSuratActivity)
            }
        }
    }

    override fun onUserClicked(nomorAyat: String, clicked: String) {
        nomorSurat?.let { HafalanAyatActivity.start(this@HafalanSuratActivity, it, nomorAyat) }
    }

    companion object {
        fun start(context: Context, nomorSurat: String) {
            val starter = Intent(context, HafalanSuratActivity::class.java)
                .putExtra(NOMOR_SURAT, nomorSurat)
            context.startActivity(starter)
        }
    }
}