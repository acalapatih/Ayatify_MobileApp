package com.acalapatih.ayatify.ui.bookmark.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.acalapatih.ayatify.BaseActivity
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.core.factory.SettingViewModelFactory
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import com.acalapatih.ayatify.databinding.FragmentBookmarkBinding
import com.acalapatih.ayatify.ui.bookmark.activity.AyatDisimpan
import com.acalapatih.ayatify.ui.bookmark.adapter.BookmarkAdapter
import com.acalapatih.ayatify.ui.bookmark.viewmodel.BookmarkViewModel
import com.acalapatih.ayatify.ui.setting.SettingViewModel
import com.acalapatih.ayatify.utils.dataStore
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarkFragment : Fragment() {

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<BookmarkViewModel>()
    private lateinit var bookmarkAdapter: BookmarkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObserver()
    }

    private fun initView() {
        val pengaturanPref = SettingPreferences.getInstance(requireContext().dataStore)
        val settingViewModel = ViewModelProvider(
            this,
            SettingViewModelFactory(pengaturanPref)
        )[SettingViewModel::class.java]

        settingViewModel.getThemeSetting().observe(viewLifecycleOwner) { isDarkModeActive: Boolean ->
            with(binding) {
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    icTerakhirDibaca.setImageResource(R.drawable.ic_dibaca_dark)
                    icAyatFavorit.setImageResource(R.drawable.ic_ayat_favorit_dark)

                    bookmarkAdapter = BookmarkAdapter(requireContext(), isDarkModeActive)
                    val layoutManager = LinearLayoutManager(requireContext())
                    val itemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
                    with(binding.rvAyat) {
                        setLayoutManager(layoutManager)
                        addItemDecoration(itemDecoration)
                        adapter = bookmarkAdapter
                    }
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    icTerakhirDibaca.setImageResource(R.drawable.ic_dibaca_light)
                    icAyatFavorit.setImageResource(R.drawable.ic_ayat_favorit_light)

                    bookmarkAdapter = BookmarkAdapter(requireContext(), isDarkModeActive)
                    val layoutManager = LinearLayoutManager(requireContext())
                    val itemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
                    with(binding.rvAyat) {
                        setLayoutManager(layoutManager)
                        addItemDecoration(itemDecoration)
                        adapter = bookmarkAdapter
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initObserver() {
        viewModel.ayatDibaca.observe(viewLifecycleOwner) { data ->
            if (data != null) {
                with(binding.tvAyatDibaca) {
                    text = "Q.S ${data.namaSurat} : ${data.nomorAyat}"

                    setOnClickListener {
                        AyatDisimpan.start(requireContext(), data.nomorSurat, data.nomorAyat)
                    }
                }
            } else {
                binding.tvAyatDibaca.text = "Belum ada ayat yang ditandai"
            }
        }

        viewModel.getAllAyatFavorit().observe(viewLifecycleOwner) { listAyatFavorit ->
            if (listAyatFavorit != null) {
                bookmarkAdapter.setListFavorite(listAyatFavorit)

                bookmarkAdapter.hapusAyatFavorit = { ayatFavorit ->
                    val baseActivity = activity as? BaseActivity<*>
                    baseActivity?.showDialogHapusAyatFavorit {
                        viewModel.delete(ayatFavorit)
                    }
                }
            } else {
                binding.tvNoDataAyatFavorit.isVisible = true
            }
        }
    }
}