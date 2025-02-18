package com.acalapatih.ayatify.ui.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.core.factory.SettingViewModelFactory
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import com.acalapatih.ayatify.databinding.FragmentQuranBinding
import com.acalapatih.ayatify.ui.bacaquran.activity.BacaQuranActivity
import com.acalapatih.ayatify.ui.hafalanquran.activity.HafalanQuranActivity
import com.acalapatih.ayatify.ui.setting.SettingViewModel
import com.acalapatih.ayatify.utils.dataStore

class QuranFragment : Fragment() {

    private var _binding: FragmentQuranBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListener()
    }

    private fun initView() {
        val pengaturanPref = SettingPreferences.getInstance(requireContext().dataStore)
        val settingViewModel = ViewModelProvider(
            this,
            SettingViewModelFactory(pengaturanPref)
        )[SettingViewModel::class.java]

        settingViewModel.getThemeSetting().observe(viewLifecycleOwner) { isDarkModeActive: Boolean ->
            with (binding) {
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    icTerakhirDibaca.setImageResource(R.drawable.ic_dibaca_dark)
                    icHafalanQuran.setImageResource(R.drawable.ic_dihafal_dark)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    icTerakhirDibaca.setImageResource(R.drawable.ic_dibaca_light)
                    icHafalanQuran.setImageResource(R.drawable.ic_dihafal_light)
                }
            }
        }
    }

    private fun initListener() {
        with(binding) {
            cvWidgetBacaQuran.setOnClickListener {
                BacaQuranActivity.start(requireContext())
            }
            cvWidgetHafalanQuran.setOnClickListener {
                HafalanQuranActivity.start(requireContext())
            }
        }
    }
}