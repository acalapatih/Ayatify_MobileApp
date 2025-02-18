package com.acalapatih.ayatify.ui.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.databinding.ActivityOnboardingBinding
import com.acalapatih.ayatify.ui.home.activity.HomeActivity
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity: AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewPager.adapter = OnboardingViewPagerAdapter(
                this@OnboardingActivity,
                this@OnboardingActivity
            )
            viewPager.offscreenPageLimit = 1
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    if (position == 2) {
                        btnNextStep.text = getText(R.string.tv_finish)
                    } else {
                        btnNextStep.text = getText(R.string.next)
                    }
                }

                override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
                override fun onPageScrollStateChanged(arg0: Int) {}
            })
            TabLayoutMediator(binding.pageIndicator, viewPager) { _, _ -> }.attach()

            btnNextStep.setOnClickListener {
                if (getItem() > viewPager.childCount) {
                    HomeActivity.start(this@OnboardingActivity, "home")
                    finish()
                } else {
                    viewPager.setCurrentItem(getItem() + 1, true)
                }
            }

            btnPreviousStep.setOnClickListener {
                if (getItem() == 0) {
                    finish()
                } else {
                    viewPager.setCurrentItem(getItem() - 1, true)
                }
            }
        }

    }

    private fun getItem(): Int {
        return binding.viewPager.currentItem
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, OnboardingActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(starter)
        }
    }
}