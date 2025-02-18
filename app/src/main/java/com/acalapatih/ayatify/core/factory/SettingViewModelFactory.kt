package com.acalapatih.ayatify.core.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import com.acalapatih.ayatify.ui.setting.SettingViewModel

class SettingViewModelFactory(
    private val pref: SettingPreferences
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingViewModel::class.java)) {
            return SettingViewModel(pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}