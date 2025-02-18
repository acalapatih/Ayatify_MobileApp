package com.acalapatih.ayatify.ui.bacaquran

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.acalapatih.ayatify.ui.bacaquran.fragment.ListJuzFragment
import com.acalapatih.ayatify.ui.bacaquran.fragment.ListSuratFragment

class SectionsPagerAdapter(
    activity: AppCompatActivity
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = ListSuratFragment()
            1 -> fragment = ListJuzFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}