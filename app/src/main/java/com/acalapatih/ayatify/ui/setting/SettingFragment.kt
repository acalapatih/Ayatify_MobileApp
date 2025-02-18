package com.acalapatih.ayatify.ui.setting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.core.factory.SettingViewModelFactory
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import com.acalapatih.ayatify.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "setting")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSwitch()
    }

    private fun initSwitch() {
        val switchTheme = binding.switchModeLatar

        val pengaturanPref = SettingPreferences.getInstance(requireContext().dataStore)
        val settingViewModel = ViewModelProvider(
            this,
            SettingViewModelFactory(pengaturanPref)
        )[SettingViewModel::class.java]

        settingViewModel.getThemeSetting().observe(viewLifecycleOwner) { isDarkModeActive: Boolean ->
            with(binding) {
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    switchTheme.isChecked = true
                    icLight.setImageResource(R.drawable.ic_sun_dark)
                    icDark.setImageResource(R.drawable.ic_moon_dark)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    switchTheme.isChecked = false
                    icLight.setImageResource(R.drawable.ic_sun_light)
                    icDark.setImageResource(R.drawable.ic_moon_light)
                }
            }
        }

        switchTheme.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
            settingViewModel.saveThemeSetting(isChecked)
        }
    }
}