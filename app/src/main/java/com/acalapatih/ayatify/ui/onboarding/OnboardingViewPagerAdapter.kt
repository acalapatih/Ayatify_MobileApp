package com.acalapatih.ayatify.ui.onboarding

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.acalapatih.ayatify.R

class OnboardingViewPagerAdapter(
    fragmentActivity: OnboardingActivity,
    private val context: Context
): FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_1),
                context.resources.getString(R.string.description_onboarding_1),
                R.drawable.img_quran
            )
            1 -> OnboardingFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_2),
                context.resources.getString(R.string.description_onboarding_2),
                R.drawable.img_speech
            )
            else -> OnboardingFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_3),
                context.resources.getString(R.string.description_onboarding_3),
                R.drawable.img_progress
            )
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}