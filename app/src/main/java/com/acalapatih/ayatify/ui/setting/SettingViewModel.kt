package com.acalapatih.ayatify.ui.setting

import androidx.lifecycle.*
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import kotlinx.coroutines.launch

class SettingViewModel(
    private val preferences: SettingPreferences
): ViewModel() {
    fun getThemeSetting(): LiveData<Boolean> {
        return preferences.getThemeSetting().asLiveData()
    }

    fun saveThemeSetting(isDarkModeActive: Boolean) {
        viewModelScope.launch {
            preferences.saveThemeSetting(isDarkModeActive)
        }
    }
}