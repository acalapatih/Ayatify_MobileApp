package com.acalapatih.ayatify.ui.bacaquran.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.acalapatih.ayatify.core.data.Resource
import com.acalapatih.ayatify.core.domain.model.bacaquran.ListSuratModel
import com.acalapatih.ayatify.core.factory.SettingViewModelFactory
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import com.acalapatih.ayatify.databinding.FragmentListSuratBinding
import com.acalapatih.ayatify.ui.bacaquran.activity.BacaSuratActivity
import com.acalapatih.ayatify.ui.bacaquran.viewmodel.ListSuratViewModel
import com.acalapatih.ayatify.ui.bacaquran.adapter.ListSuratAdapter
import com.acalapatih.ayatify.ui.setting.SettingViewModel
import com.acalapatih.ayatify.utils.dataStore
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListSuratFragment : Fragment(), ListSuratAdapter.OnUserClickListener {

    private var _binding: FragmentListSuratBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<ListSuratViewModel>()
    private lateinit var listSuratAdapter: ListSuratAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListSuratBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getListSurat()

        initView()
        initObserver()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(requireContext())
        val itemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
        with(binding.rvSurat) {
            setLayoutManager(layoutManager)
            addItemDecoration(itemDecoration)
        }
    }

    private fun initObserver() {
        viewModel.getListSurat.observe(viewLifecycleOwner) { model ->
            when (model) {
                is Resource.Loading -> {
                    showLoading(true)
                }
                is Resource.Success -> {
                    showLoading(false)
                    model.data?.let { data ->
                        getListSurah(data)
                    }
                }
                is Resource.Error -> {
                    showLoading(false)
                    model.message?.let {
                        println(it)
                        Toast.makeText(
                            requireContext(),
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

    private fun getListSurah(data: ListSuratModel) {
        val pengaturanPref = SettingPreferences.getInstance(requireContext().dataStore)
        val settingViewModel = ViewModelProvider(
            this,
            SettingViewModelFactory(pengaturanPref)
        )[SettingViewModel::class.java]
        val listener = this

        settingViewModel.getThemeSetting().observe(viewLifecycleOwner) { isDarkModeActive: Boolean ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                listSuratAdapter = ListSuratAdapter(data.listSurat, isDarkModeActive, listener)
                binding.rvSurat.adapter = listSuratAdapter
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                listSuratAdapter = ListSuratAdapter(data.listSurat, isDarkModeActive, listener)
                binding.rvSurat.adapter = listSuratAdapter
            }
        }
    }

    override fun onUserClicked(nomorSurat: String, clicked: String) {
        BacaSuratActivity.start(requireContext(), nomorSurat)
    }
}