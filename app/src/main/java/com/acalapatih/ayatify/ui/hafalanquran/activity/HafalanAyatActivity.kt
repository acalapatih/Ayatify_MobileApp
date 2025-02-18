package com.acalapatih.ayatify.ui.hafalanquran.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.acalapatih.ayatify.BaseActivity
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.data.source.local.entity.*
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanAyatModel
import com.acalapatih.ayatify.core.factory.SettingViewModelFactory
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import com.acalapatih.ayatify.databinding.ActivityHafalanAyatBinding
import com.acalapatih.ayatify.ui.bookmark.activity.BookmarkActivity
import com.acalapatih.ayatify.ui.hafalanquran.viewmodel.HafalanAyatViewModel
import com.acalapatih.ayatify.ui.setting.SettingViewModel
import com.acalapatih.ayatify.utils.Const
import com.acalapatih.ayatify.utils.dataStore
import org.apache.commons.text.similarity.JaroWinklerSimilarity
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class HafalanAyatActivity : BaseActivity<ActivityHafalanAyatBinding>() {
    private val viewModel by viewModel<HafalanAyatViewModel>()
    private val nomorSurat by lazy { intent.getStringExtra(Const.NOMOR_SURAT) }
    private val nomorAyat by lazy { intent.getStringExtra(Const.NOMOR_AYAT) }
    private lateinit var audioAyatPlayer: MediaPlayer
    private lateinit var speechRecognizer: SpeechRecognizer

    override fun getViewBinding(): ActivityHafalanAyatBinding =
        ActivityHafalanAyatBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        nomorSurat?.let { nomorAyat?.let { it1 -> viewModel.getAyat(it, it1) } }

        initView()
    }

    private fun initView() {
        requestPermissions()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            Const.REQUEST_PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                    initObserver()
                    initListener()
                } else {
                    showToast(
                        this.getString(R.string.toast_permission),
                        Toast.LENGTH_SHORT
                    )
                    onBackPressedDispatcher.onBackPressed()
                    onBackPressedDispatcher.addCallback(this) {
                        finish()
                    }
                }
            }
        }
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.RECORD_AUDIO
            ),
            Const.REQUEST_PERMISSION_CODE
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initObserver() {
        viewModel.getAyat.observe(this) { model ->
            when (model) {
                is Resource.Loading -> {
                    showLoading(true)
                }
                is Resource.Success -> {
                    showLoading(false)
                    model.data?.let { data ->
                        getAyat(data)
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

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    private fun getAyat(data: HafalanAyatModel) {
        val pengaturanPref = SettingPreferences.getInstance(dataStore)
        val settingViewModel = ViewModelProvider(
            this,
            SettingViewModelFactory(pengaturanPref)
        )[SettingViewModel::class.java]

        settingViewModel.getThemeSetting().observe(this@HafalanAyatActivity) { isDarkModeActive: Boolean ->
            with(binding) {
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    icBack.setImageResource(R.drawable.ic_back_dark)
                    icBookmark.setImageResource(R.drawable.ic_bookmark_dark)
                    tvAudioAyat.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_audio_dark, 0, 0, 0)
                    clHasilHafalan.setBackgroundResource(R.drawable.bg_hasil_hafalan_dark)
                    cvAudioAyat.backgroundTintList = ContextCompat.getColorStateList(this@HafalanAyatActivity, R.color.blue_001C30)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    icBack.setImageResource(R.drawable.ic_back_light)
                    icBookmark.setImageResource(R.drawable.ic_bookmark_light)
                    tvAudioAyat.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_audio_light, 0, 0, 0)
                    clHasilHafalan.setBackgroundResource(R.drawable.bg_hasil_hafalan_light)
                    cvAudioAyat.backgroundTintList = ContextCompat.getColorStateList(this@HafalanAyatActivity, R.color.white)
                }

                tvSurat.text = data.namaSurat
                tvAyatKe.text = "Ayat ${data.nomorAyat}"
                tvAyat.text = data.lafadzAyat

                btnAudio.setOnClickListener {
                    cvAudioAyat.isVisible = true
                    tvAudioAyat.text = "${data.namaSurat} : ${data.nomorAyat}"

                    audioAyatPlayer = MediaPlayer.create(this@HafalanAyatActivity, data.audioAyat.toUri())
                    audioAyatPlayer.start()

                    btnStop.setOnClickListener {
                        audioAyatPlayer.stop()
                        audioAyatPlayer.release()
                        cvAudioAyat.isVisible = false
                    }
                }
                btnRekam.setOnClickListener {
                    tvAyat.visibility = View.GONE
                    cvHasilHafalan.visibility = View.GONE
                    showDialogRekamSuara(
                        onClose = { binding.tvAyat.isVisible = true },
                        onStartRecording = { startRecording() },
                        onStopRecording = { stopRecording(
                            data.namaSurat,
                            data.nomorAyat,
                            data.lafadzAyat
                        ) }
                    )
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun startRecording() {
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-SA") // Bahasa Arab (Saudi Arabia)

        speechRecognizer.startListening(speechRecognizerIntent)
    }

    private fun stopRecording(namaSurat: String, nomorAyat: String, lafadzAyat: String) {
        speechRecognizer.stopListening()

        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {}

            override fun onBeginningOfSpeech() {}

            override fun onRmsChanged(rmsdB: Float) {}

            override fun onBufferReceived(buffer: ByteArray?) {}

            override fun onEndOfSpeech() {}

            override fun onError(error: Int) {
                Log.e("SpeechRecognition", "Error: $error")
                Toast.makeText(this@HafalanAyatActivity, "Terjadi Kesalahan, Silakan Coba Kembali", Toast.LENGTH_SHORT).show()
                binding.tvAyat.visibility = View.VISIBLE
            }

            override fun onResults(results: Bundle?) {
                val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                if (matches != null && matches.isNotEmpty()) {
                    val recognizedText = matches[0]
                    speechToTextResult(namaSurat, nomorAyat, lafadzAyat, recognizedText)
                }
            }

            override fun onPartialResults(partialResults: Bundle?) {}

            override fun onEvent(eventType: Int, params: Bundle?) {}
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::speechRecognizer.isInitialized) {
            speechRecognizer.destroy()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun speechToTextResult(namaSurat: String, nomorAyat: String, lafadzAyat: String, textResult: String) {
        with(binding) {
            cvHasilHafalan.visibility = View.VISIBLE
            tvAyat.isVisible = true
            tvAyatKesalahan.text = textResult

            val jaroWinklerSimilarity = JaroWinklerSimilarity()
            val similarity = jaroWinklerSimilarity.apply(lafadzAyat, textResult)
            println("Jaro-Winkler Similarity: $similarity")

            when(similarity) {
                in 0.71..1.0 ->
                {
                    tvPersentaseKemiripan.text = "${(similarity * 100).toInt()}"
                    tvPredikatHasil.text = "Sangat Baik"
                    tvPredikatHasil.setTextColor(ContextCompat.getColor(this@HafalanAyatActivity, R.color.green_9ACD32))
                    tvAyatSelanjutnya.isVisible = true
                    tvLetakKesalahan.isVisible = false
                    tvAyatKesalahan.isVisible = false

                    when (namaSurat) {
                        "Al-Fatihah" -> checkAndInsertAlFatihah(namaSurat, nomorAyat.toInt())
                        "An-Nas" -> checkAndInsertAnNas(namaSurat, nomorAyat.toInt())
                        "Al-Falaq" -> checkAndInsertAlFalaq(namaSurat, nomorAyat.toInt())
                        "Al-Ikhlas" -> checkAndInsertAlIkhlas(namaSurat, nomorAyat.toInt())
                        "Al-Lahab" -> checkAndInsertAlLahab(namaSurat, nomorAyat.toInt())
                        "An-Nasr" -> checkAndInsertAnNasr(namaSurat, nomorAyat.toInt())
                        "Al-Kafirun" -> checkAndInsertAlKafirun(namaSurat, nomorAyat.toInt())
                        "Al-Kausar" -> checkAndInsertAlKausar(namaSurat, nomorAyat.toInt())
                        "Al-Ma'un" -> checkAndInsertAlMaun(namaSurat, nomorAyat.toInt())
                        "Quraisy" -> checkAndInsertAlQuraisy(namaSurat, nomorAyat.toInt())
                        "Al-Fil" -> checkAndInsertAlFil(namaSurat, nomorAyat.toInt())
                        "Al-Humazah" -> checkAndInsertAlHumazah(namaSurat, nomorAyat.toInt())
                        "Al-'Asr" -> checkAndInsertAlAsr(namaSurat, nomorAyat.toInt())
                        "At-Takasur" -> checkAndInsertAtTakasur(namaSurat, nomorAyat.toInt())
                        "Al-Qari'ah" -> checkAndInsertAlQariah(namaSurat, nomorAyat.toInt())
                        "Al-'Adiyat" -> checkAndInsertAlAdiyat(namaSurat, nomorAyat.toInt())
                        "Al-Zalzalah" -> checkAndInsertAlZalzalah(namaSurat, nomorAyat.toInt())
                        "Al-Bayyinah" -> checkAndInsertAlBayyinah(namaSurat, nomorAyat.toInt())
                        "Al-Qadr" -> checkAndInsertAlQadr(namaSurat, nomorAyat.toInt())
                        "Al-'Alaq" -> checkAndInsertAlAlaq(namaSurat, nomorAyat.toInt())
                        "At-Tin" -> checkAndInsertAtTin(namaSurat, nomorAyat.toInt())
                        "Asy-Syarh" -> checkAndInsertAsySyarh(namaSurat, nomorAyat.toInt())
                        "Ad-Duha" -> checkAndInsertAdDuha(namaSurat, nomorAyat.toInt())
                        "Al-Lail" -> checkAndInsertAlLail(namaSurat, nomorAyat.toInt())
                        "Asy-Syam" -> checkAndInsertAsySyam(namaSurat, nomorAyat.toInt())
                        "Al-Balad" -> checkAndInsertAlBalad(namaSurat, nomorAyat.toInt())
                        "Al-Fajr" -> checkAndInsertAlFajr(namaSurat, nomorAyat.toInt())
                        "Al-Gasyiyah" -> checkAndInsertAlGasyiyah(namaSurat, nomorAyat.toInt())
                        "Al-A'la" -> checkAndInsertAlAla(namaSurat, nomorAyat.toInt())
                        "At-Tariq" -> checkAndInsertAtTariq(namaSurat, nomorAyat.toInt())
                        "Al-Buruj" -> checkAndInsertAlBuruj(namaSurat, nomorAyat.toInt())
                        "Al-Insyiqaq" -> checkAndInsertAlInsyiqaq(namaSurat, nomorAyat.toInt())
                        "Al-Mutaffifin" -> checkAndInsertAlMutaffifin(namaSurat, nomorAyat.toInt())
                        "Al-Infitar" -> checkAndInsertAlInfitar(namaSurat, nomorAyat.toInt())
                        "At-Takwir" -> checkAndInsertAtTakwir(namaSurat, nomorAyat.toInt())
                        "'Abasa" -> checkAndInsertAbasa(namaSurat, nomorAyat.toInt())
                        "An-Nazi'at" -> checkAndInsertAnNaziat(namaSurat, nomorAyat.toInt())
                        "An-Naba'" -> checkAndInsertAnNaba(namaSurat, nomorAyat.toInt())
                        "Al-Mulk" -> checkAndInsertAlMulk(namaSurat, nomorAyat.toInt())
                    }

                    val ayatDihafal = nomorSurat?.let { AyatDihafal(1, it, namaSurat, nomorAyat, ambilWaktuHafalan()) }
                    if (ayatDihafal != null) {
                        viewModel.insertAyatDihafal(ayatDihafal)
                    }
                }
                in 0.41..0.7 -> {
                    tvPersentaseKemiripan.text = "${(similarity * 100).toInt()}"
                    tvPredikatHasil.text = "Cukup Baik"
                    tvPredikatHasil.setTextColor(ContextCompat.getColor(this@HafalanAyatActivity, R.color.orange_FF6900))
                    tvAyatSelanjutnya.visibility = View.GONE
                    tvLetakKesalahan.visibility = View.VISIBLE
                    tvAyatKesalahan.visibility = View.VISIBLE
                }
                in 0.1..0.4 -> {
                    tvPersentaseKemiripan.text = "${(similarity * 100).toInt()}"
                    tvPredikatHasil.text = "Kurang Baik"
                    tvPredikatHasil.setTextColor(ContextCompat.getColor(this@HafalanAyatActivity, R.color.red_F44336))
                    tvAyatSelanjutnya.visibility = View.GONE
                    tvLetakKesalahan.visibility = View.VISIBLE
                    tvAyatKesalahan.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun checkAndInsertAlFatihah(namaSurat: String, nomorAyat: Int) {
        val alFatihah = AlFatihah(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlFatihah(alFatihah)
    }

    private fun checkAndInsertAnNas(namaSurat: String, nomorAyat: Int) {
        val anNas = AnNas(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAnNas(anNas)
    }

    private fun checkAndInsertAlFalaq(namaSurat: String, nomorAyat: Int) {
        val alFalaq = AlFalaq(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlFalaq(alFalaq)
    }

    private fun checkAndInsertAlIkhlas(namaSurat: String, nomorAyat: Int) {
        val alIkhlas = AlIkhlas(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlIkhlas(alIkhlas)
    }

    private fun checkAndInsertAlLahab(namaSurat: String, nomorAyat: Int) {
        val alLahab = AlLahab(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlLahab(alLahab)
    }

    private fun checkAndInsertAnNasr(namaSurat: String, nomorAyat: Int) {
        val anNasr = AnNasr(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAnNasr(anNasr)
    }

    private fun checkAndInsertAlKafirun(namaSurat: String, nomorAyat: Int) {
        val alKafirun = AlKafirun(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlKafirun(alKafirun)
    }

    private fun checkAndInsertAlKausar(namaSurat: String, nomorAyat: Int) {
        val alKausar = AlKausar(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlKausar(alKausar)
    }

    private fun checkAndInsertAlMaun(namaSurat: String, nomorAyat: Int) {
        val alMaun = AlMaun(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlMaun(alMaun)
    }

    private fun checkAndInsertAlQuraisy(namaSurat: String, nomorAyat: Int) {
        val alQuraisy = AlQuraisy(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlQuraisy(alQuraisy)
    }

    private fun checkAndInsertAlFil(namaSurat: String, nomorAyat: Int) {
        val alFil = AlFil(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlFil(alFil)
    }

    private fun checkAndInsertAlHumazah(namaSurat: String, nomorAyat: Int) {
        val alHumazah = AlHumazah(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlHumazah(alHumazah)
    }

    private fun checkAndInsertAlAsr(namaSurat: String, nomorAyat: Int) {
        val alAsr = AlAsr(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlAsr(alAsr)
    }

    private fun checkAndInsertAtTakasur(namaSurat: String, nomorAyat: Int) {
        val atTakasur = AtTakasur(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAtTakasur(atTakasur)
    }

    private fun checkAndInsertAlQariah(namaSurat: String, nomorAyat: Int) {
        val alQariah = AlQariah(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlQariah(alQariah)
    }

    private fun checkAndInsertAlAdiyat(namaSurat: String, nomorAyat: Int) {
        val alAdiyat = AlAdiyat(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlAdiyat(alAdiyat)
    }

    private fun checkAndInsertAlZalzalah(namaSurat: String, nomorAyat: Int) {
        val alZalzalah = AlZalzalah(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlZalzalah(alZalzalah)
    }

    private fun checkAndInsertAlBayyinah(namaSurat: String, nomorAyat: Int) {
        val alBayyinah = AlBayyinah(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlBayyinah(alBayyinah)
    }

    private fun checkAndInsertAlQadr(namaSurat: String, nomorAyat: Int) {
        val alQadr = AlQadr(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlQadr(alQadr)
    }

    private fun checkAndInsertAlAlaq(namaSurat: String, nomorAyat: Int) {
        val alAlaq = AlAlaq(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlAlaq(alAlaq)
    }

    private fun checkAndInsertAtTin(namaSurat: String, nomorAyat: Int) {
        val atTin = AtTin(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAtTin(atTin)
    }

    private fun checkAndInsertAsySyarh(namaSurat: String, nomorAyat: Int) {
        val asySyarh = AsySyarh(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAsySyarh(asySyarh)
    }

    private fun checkAndInsertAdDuha(namaSurat: String, nomorAyat: Int) {
        val adDuha = AdDuha(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAdDuha(adDuha)
    }

    private fun checkAndInsertAlLail(namaSurat: String, nomorAyat: Int) {
        val alLail = AlLail(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlLail(alLail)
    }

    private fun checkAndInsertAsySyam(namaSurat: String, nomorAyat: Int) {
        val asySyam = AsySyam(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAsySyam(asySyam)
    }

    private fun checkAndInsertAlBalad(namaSurat: String, nomorAyat: Int) {
        val alBalad = AlBalad(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlBalad(alBalad)
    }

    private fun checkAndInsertAlFajr(namaSurat: String, nomorAyat: Int) {
        val alFajr = AlFajr(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlFajr(alFajr)
    }

    private fun checkAndInsertAlGasyiyah(namaSurat: String, nomorAyat: Int) {
        val alGasyiyah = AlGasyiyah(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlGasyiyah(alGasyiyah)
    }

    private fun checkAndInsertAlAla(namaSurat: String, nomorAyat: Int) {
        val alAla = AlAla(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlAla(alAla)
    }

    private fun checkAndInsertAtTariq(namaSurat: String, nomorAyat: Int) {
        val atTariq = AtTariq(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAtTariq(atTariq)
    }

    private fun checkAndInsertAlBuruj(namaSurat: String, nomorAyat: Int) {
        val alBuruj = AlBuruj(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlBuruj(alBuruj)
    }

    private fun checkAndInsertAlInsyiqaq(namaSurat: String, nomorAyat: Int) {
        val alInsyiqaq = AlInsyiqaq(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlInsyiqaq(alInsyiqaq)
    }

    private fun checkAndInsertAlMutaffifin(namaSurat: String, nomorAyat: Int) {
        val alMutaffifin = AlMutaffifin(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlMutaffifin(alMutaffifin)
    }

    private fun checkAndInsertAlInfitar(namaSurat: String, nomorAyat: Int) {
        val alInfitar = AlInfitar(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlInfitar(alInfitar)
    }

    private fun checkAndInsertAtTakwir(namaSurat: String, nomorAyat: Int) {
        val atTakwir = AtTakwir(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAtTakwir(atTakwir)
    }

    private fun checkAndInsertAbasa(namaSurat: String, nomorAyat: Int) {
        val abasa = Abasa(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAbasa(abasa)
    }

    private fun checkAndInsertAnNaziat(namaSurat: String, nomorAyat: Int) {
        val anNaziat = AnNaziat(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAnNaziat(anNaziat)
    }

    private fun checkAndInsertAnNaba(namaSurat: String, nomorAyat: Int) {
        val anNaba = AnNaba(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAnNaba(anNaba)
    }

    private fun checkAndInsertAlMulk(namaSurat: String, nomorAyat: Int) {
        val alMulk = AlMulk(nomorAyat, namaSurat, nomorAyat, "dihafal")
        viewModel.insertAlMulk(alMulk)
    }

    @SuppressLint("SimpleDateFormat")
    private fun ambilWaktuHafalan(): String {
        val calendar = Calendar.getInstance()

        val waktuFormat = SimpleDateFormat("HH:mm:ss")
        val waktuString = waktuFormat.format(calendar.time)

        val hari = calendar.get(Calendar.DAY_OF_WEEK)

        val hariString = when (hari) {
            Calendar.SUNDAY -> "Sunday"
            Calendar.MONDAY -> "Monday"
            Calendar.TUESDAY -> "Tuesday"
            Calendar.WEDNESDAY -> "Wednesday"
            Calendar.THURSDAY -> "Thursday"
            Calendar.FRIDAY -> "Friday"
            Calendar.SATURDAY -> "Saturday"
            else -> "Unknown"
        }

        val tanggalFormat = SimpleDateFormat("dd/MM/yyyy")
        val tanggalString = tanggalFormat.format(calendar.time)

        return "$waktuString, $hariString, $tanggalString"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initListener() {
        with(binding) {
            icBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            onBackPressedDispatcher.addCallback(this@HafalanAyatActivity) {
                finish()
            }

            icBookmark.setOnClickListener {
                BookmarkActivity.start(this@HafalanAyatActivity)
            }
            tvAyatSelanjutnya.setOnClickListener {
                nomorSurat?.let { it1 ->
                    start(this@HafalanAyatActivity,
                        it1, (nomorAyat?.toInt()?.plus(1)).toString())
                }
                finish()
            }
        }
    }

    companion object {
        fun start(context: Context, nomorSurat: String, nomorAyat: String) {
            val starter = Intent(context, HafalanAyatActivity::class.java)
                .putExtra(Const.NOMOR_SURAT, nomorSurat)
                .putExtra(Const.NOMOR_AYAT, nomorAyat)
            context.startActivity(starter)
        }
    }
}