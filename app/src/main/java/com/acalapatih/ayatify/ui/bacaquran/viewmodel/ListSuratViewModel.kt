package com.acalapatih.ayatify.ui.bacaquran.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.ListSuratModel
import com.acalapatih.ayatify.core.domain.usecase.bacaquran.BacaQuranUsecase
import kotlinx.coroutines.launch

class ListSuratViewModel(
    private val usecase: BacaQuranUsecase
): ViewModel() {
    private val _getListSurat = MutableLiveData<Resource<ListSuratModel>>()
    val getListSurat: LiveData<Resource<ListSuratModel>> get() = _getListSurat

    fun getListSurat() {
        viewModelScope.launch {
            usecase.getListSurat().collect{
                _getListSurat.value = it
            }
        }
    }
}