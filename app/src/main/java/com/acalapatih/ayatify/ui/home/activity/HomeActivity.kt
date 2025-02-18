package com.acalapatih.ayatify.ui.home.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.databinding.ActivityHomeBinding
import com.acalapatih.ayatify.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity: BaseActivity<ActivityHomeBinding>() {
    private lateinit var navController: NavController
    private lateinit var navView: BottomNavigationView
    private lateinit var menu: Menu

    override fun getViewBinding(): ActivityHomeBinding =
        ActivityHomeBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        initBottomNav()
    }

    private fun initBottomNav() {
        navView = binding.navView
        menu = navView.menu
        navController = findNavController(R.id.nav_host_fragment_activity_home)
        navView.setupWithNavController(navController)
        navController.setGraph(R.navigation.app_navigation)

        when (intent.getStringExtra("action")) {
            "home" -> {
                navController.navigate(R.id.navigation_home)
                menu.findItem(R.id.navigation_home).setIcon(R.drawable.ic_home_selected)
                menu.findItem(R.id.navigation_quran).setIcon(R.drawable.ic_quran_unselected)
                menu.findItem(R.id.navigation_bookmark).setIcon(R.drawable.ic_bookmark_unselected)
                menu.findItem(R.id.navigation_setting).setIcon(R.drawable.ic_setting_unselected)
            }
            "quran" -> {
                navController.navigate(R.id.navigation_quran)
                menu.findItem(R.id.navigation_home).setIcon(R.drawable.ic_home)
                menu.findItem(R.id.navigation_quran).setIcon(R.drawable.ic_quran_selected_light)
                menu.findItem(R.id.navigation_bookmark).setIcon(R.drawable.ic_bookmark_unselected)
                menu.findItem(R.id.navigation_setting).setIcon(R.drawable.ic_setting_unselected)
            }
            "penanda" -> {
                navController.navigate(R.id.navigation_bookmark)
                menu.findItem(R.id.navigation_home).setIcon(R.drawable.ic_home)
                menu.findItem(R.id.navigation_quran).setIcon(R.drawable.ic_quran_unselected)
                menu.findItem(R.id.navigation_bookmark).setIcon(R.drawable.ic_bookmark_selected)
                menu.findItem(R.id.navigation_setting).setIcon(R.drawable.ic_setting_unselected)
            }
            else -> {
                navController.navigate(R.id.navigation_setting)
                menu.findItem(R.id.navigation_home).setIcon(R.drawable.ic_home)
                menu.findItem(R.id.navigation_quran).setIcon(R.drawable.ic_quran_unselected)
                menu.findItem(R.id.navigation_bookmark).setIcon(R.drawable.ic_bookmark_unselected)
                menu.findItem(R.id.navigation_setting).setIcon(R.drawable.ic_setting_selected)
            }
        }

        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    item.setIcon(R.drawable.ic_home_selected)
                    menu.findItem(R.id.navigation_quran).setIcon(R.drawable.ic_quran_unselected)
                    menu.findItem(R.id.navigation_bookmark).setIcon(R.drawable.ic_bookmark_unselected)
                    menu.findItem(R.id.navigation_setting).setIcon(R.drawable.ic_setting_unselected)
                    navController.navigate(R.id.navigation_home)
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_quran -> {
                    item.setIcon(R.drawable.ic_quran_selected_light)
                    menu.findItem(R.id.navigation_home).setIcon(R.drawable.ic_home)
                    menu.findItem(R.id.navigation_bookmark).setIcon(R.drawable.ic_bookmark_unselected)
                    menu.findItem(R.id.navigation_setting).setIcon(R.drawable.ic_setting_unselected)
                    navController.navigate(R.id.navigation_quran)
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_bookmark -> {
                    item.setIcon(R.drawable.ic_bookmark_selected)
                    menu.findItem(R.id.navigation_home).setIcon(R.drawable.ic_home)
                    menu.findItem(R.id.navigation_quran).setIcon(R.drawable.ic_quran_unselected)
                    menu.findItem(R.id.navigation_setting).setIcon(R.drawable.ic_setting_unselected)
                    navController.navigate(R.id.navigation_bookmark)
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_setting -> {
                    item.setIcon(R.drawable.ic_setting_selected)
                    menu.findItem(R.id.navigation_home).setIcon(R.drawable.ic_home)
                    menu.findItem(R.id.navigation_quran).setIcon(R.drawable.ic_quran_unselected)
                    menu.findItem(R.id.navigation_bookmark).setIcon(R.drawable.ic_bookmark_unselected)
                    navController.navigate(R.id.navigation_setting)
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun start(context: Context, value: String? = "") {
            val starter = Intent(context, HomeActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                .putExtra("action", value)
            context.startActivity(starter)
        }
    }
}