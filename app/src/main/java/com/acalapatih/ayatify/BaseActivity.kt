package com.acalapatih.ayatify

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.acalapatih.ayatify.databinding.ItemDialogAturNotifikasiBinding
import com.acalapatih.ayatify.databinding.ItemDialogAyatFavoritBinding
import com.acalapatih.ayatify.databinding.ItemDialogHapusAyatFavoritBinding
import com.acalapatih.ayatify.databinding.ItemDialogRekamSuaraBinding
import com.acalapatih.ayatify.databinding.ItemDialogStatusHafalanBinding
import com.acalapatih.ayatify.databinding.ItemDialogTerakhirDibacaBinding

abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity() {
    abstract fun getViewBinding(): VB

    private lateinit var _binding: VB
    val binding: VB
        get() {
            if (::_binding.isInitialized) return _binding
            else _binding = getViewBinding()
            return _binding
        }

    private var selectedHour: Int = 6
    private var selectedMinute: Int = 0

    private fun getLayoutResource(): View = binding.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(getLayoutResource())
    }

    protected fun showToast(message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }

    protected fun showDialogTerakhirDibaca(
        onSimpanButtonClicked: () -> Unit
    ) {
        val dialog = Dialog(this)
        val dialogBinding = ItemDialogTerakhirDibacaBinding.inflate(layoutInflater)
        val window = dialog.window

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogBinding.root)

        val deviceWidth: Int = Resources.getSystem().displayMetrics.widthPixels
        val margin = (60 * Resources.getSystem().displayMetrics.density).toInt()
        val width: Int = deviceWidth - margin
        window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        dialog.show()

        with(dialogBinding) {
            icClose.setOnClickListener {
                dialog.dismiss()
            }
            btnSimpan.setOnClickListener {
                onSimpanButtonClicked.invoke()
                showToast(
                    "Berhasil menandai ayat yang terakhir dibaca",
                    Toast.LENGTH_SHORT
                )
                dialog.dismiss()
            }
            btnBatal.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    protected fun showDialogAyatFavorit(
        onSimpanButtonClicked: () -> Unit
    ) {
        val dialog = Dialog(this)
        val dialogBinding = ItemDialogAyatFavoritBinding.inflate(layoutInflater)
        val window = dialog.window

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogBinding.root)

        val deviceWidth: Int = Resources.getSystem().displayMetrics.widthPixels
        val margin = (60 * Resources.getSystem().displayMetrics.density).toInt()
        val width: Int = deviceWidth - margin
        window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        dialog.show()

        with(dialogBinding) {
            icClose.setOnClickListener {
                dialog.dismiss()
            }
            btnSimpan.setOnClickListener {
                onSimpanButtonClicked.invoke()
                showToast(
                    "Ayat Favorit Berhasil Disimpan",
                    Toast.LENGTH_SHORT
                )
                dialog.dismiss()
            }
            btnBatal.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    fun showDialogHapusAyatFavorit(
        onSimpanButtonClicked: () -> Unit
    ) {
        val dialog = Dialog(this)
        val dialogBinding = ItemDialogHapusAyatFavoritBinding.inflate(layoutInflater)
        val window = dialog.window

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogBinding.root)

        val deviceWidth: Int = Resources.getSystem().displayMetrics.widthPixels
        val margin = (60 * Resources.getSystem().displayMetrics.density).toInt()
        val width: Int = deviceWidth - margin
        window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        dialog.show()

        with(dialogBinding) {
            icClose.setOnClickListener {
                dialog.dismiss()
            }
            btnSimpan.setOnClickListener {
                onSimpanButtonClicked.invoke()
                showToast(
                    "Ayat Favorit Berhasil Dihapus",
                    Toast.LENGTH_SHORT
                )
                dialog.dismiss()
            }
            btnBatal.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    protected fun showDialogAturNotifikasi(
        onSimpanButtonClicked: ((hour: Int, minute: Int) -> Unit)? = null,
    ) {
        val dialog = Dialog(this)
        val dialogBinding = ItemDialogAturNotifikasiBinding.inflate(layoutInflater)
        val window = dialog.window

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogBinding.root)

        val deviceWidth: Int = Resources.getSystem().displayMetrics.widthPixels
        val margin = (60 * Resources.getSystem().displayMetrics.density).toInt()
        val width: Int = deviceWidth - margin
        window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        dialog.show()

        with(dialogBinding) {
            icClose.setOnClickListener {
                dialog.dismiss()
            }
            tpNotifikasiPengingat.setOnTimeChangedListener { view, hourOfDay, minute ->
                selectedHour = hourOfDay
                selectedMinute = minute
            }
            btnSimpan.setOnClickListener {
                onSimpanButtonClicked?.invoke(selectedHour, selectedMinute)
                showToast(
                    "Berhasil mengatur notifikasi pengingat hafalan",
                    Toast.LENGTH_SHORT
                )
                dialog.dismiss()
            }
            btnBatal.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    @Suppress("DEPRECATION")
    protected fun showDialogRekamSuara(
        onClose: () -> Unit,
        onStartRecording: () -> Unit,
        onStopRecording: () -> Unit,
    ) {
        val dialog = Dialog(this)
        val dialogBinding = ItemDialogRekamSuaraBinding.inflate(layoutInflater)
        val window = dialog.window

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogBinding.root)

        val deviceWidth: Int = Resources.getSystem().displayMetrics.widthPixels
        val margin = (60 * Resources.getSystem().displayMetrics.density).toInt()
        val width: Int = deviceWidth - margin
        window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        dialog.show()

        with(dialogBinding) {
            icClose.setOnClickListener {
                onClose.invoke()
                dialog.dismiss()
            }

            btnRekamSuaraStart.setOnClickListener {
                icClose.visibility = View.GONE
                onStartRecording.invoke()
                showToast(
                    "Rekaman Dimulai",
                    Toast.LENGTH_SHORT
                )
                btnRekamSuaraStop.isVisible = true
                btnRekamSuaraStart.visibility = View.GONE
                tvPerintahRekamSuara.text = "Tekan tombol dibawah ini untuk menghentikan rekaman"
            }

            btnRekamSuaraStop.setOnClickListener {
                onStopRecording.invoke()
                showToast(
                    "Rekaman Berhenti",
                    Toast.LENGTH_SHORT
                )
                dialog.dismiss()
            }
        }
    }

    fun showDialogStatusHafalan() {
        val dialog = Dialog(this)
        val dialogBinding = ItemDialogStatusHafalanBinding.inflate(layoutInflater)
        val window = dialog.window

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogBinding.root)

        val deviceWidth: Int = Resources.getSystem().displayMetrics.widthPixels
        val margin = (60 * Resources.getSystem().displayMetrics.density).toInt()
        val width: Int = deviceWidth - margin
        window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        dialog.show()

        with(dialogBinding) {
            icClose.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}