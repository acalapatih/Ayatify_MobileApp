package com.acalapatih.ayatify.ui.bacaquran.fragment

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
import com.acalapatih.ayatify.core.data.source.local.entity.JuzQuran
import com.acalapatih.ayatify.core.factory.SettingViewModelFactory
import com.acalapatih.ayatify.core.data.source.local.preference.SettingPreferences
import com.acalapatih.ayatify.databinding.FragmentListJuzBinding
import com.acalapatih.ayatify.ui.bacaquran.activity.BacaJuzActivity
import com.acalapatih.ayatify.ui.bacaquran.adapter.ListJuzAdapter
import com.acalapatih.ayatify.ui.bacaquran.viewmodel.ListJuzViewModel
import com.acalapatih.ayatify.ui.setting.SettingViewModel
import com.acalapatih.ayatify.utils.dataStore
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListJuzFragment : Fragment(), ListJuzAdapter.OnUserClickListener {

    private var _binding: FragmentListJuzBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<ListJuzViewModel>()
    private lateinit var listJuzAdapter: ListJuzAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListJuzBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObserver()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(requireContext())
        val itemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
        with(binding.rvJuz) {
            setLayoutManager(layoutManager)
            addItemDecoration(itemDecoration)
        }
    }

    private fun initObserver() {
        viewModel.allListJuz.observe(viewLifecycleOwner) { listJuz ->
            listJuz?.let { data ->
                getListJuz(data)
            }
        }
    }

    private fun showLoading(value: Boolean) {
        binding.progressBar.isVisible = value
    }

    private fun getListJuz(data: List<JuzQuran>) {
        val pengaturanPref = SettingPreferences.getInstance(requireContext().dataStore)
        val settingViewModel = ViewModelProvider(
            this,
            SettingViewModelFactory(pengaturanPref)
        )[SettingViewModel::class.java]
        val listener = this

        settingViewModel.getThemeSetting().observe(viewLifecycleOwner) { isDarkModeActive: Boolean ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                listJuzAdapter = ListJuzAdapter(requireContext(), isDarkModeActive, listener)
                listJuzAdapter.setListJuz(data)
                binding.rvJuz.adapter = listJuzAdapter
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                listJuzAdapter = ListJuzAdapter(requireContext(), isDarkModeActive, listener)
                listJuzAdapter.setListJuz(data)
                binding.rvJuz.adapter = listJuzAdapter
            }
        }
    }

    override fun onUserClicked(nomorJuz: String, infoJuz: String, clicked: String) {
        BacaJuzActivity.start(requireContext(), nomorJuz, infoJuz)
    }
}