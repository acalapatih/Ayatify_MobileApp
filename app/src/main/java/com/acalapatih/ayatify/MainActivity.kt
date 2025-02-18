package com.acalapatih.ayatify

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.acalapatih.ayatify.ui.home.activity.HomeActivity
import com.acalapatih.ayatify.ui.onboarding.OnboardingActivity
import com.acalapatih.ayatify.utils.Const
import com.acalapatih.ayatify.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        activityScope.launch {
            delay(Const.DELAY_SPLASH_SCREEN)

            val sharedPreferences = getSharedPreferences("appPreferences", Context.MODE_PRIVATE)
            val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)

            if (isFirstRun) {
                sharedPreferences.edit().putBoolean("isFirstRun", false).apply()
                OnboardingActivity.start(this@MainActivity)
            } else {
                HomeActivity.start(this@MainActivity, "home")
            }

            startActivity(intent)
            finish()

//            splashScreen.setKeepVisibleCondition { it }
        }
    }
}