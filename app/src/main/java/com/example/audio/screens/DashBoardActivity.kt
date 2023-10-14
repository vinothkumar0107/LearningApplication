package com.example.audio.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.audio.fragment.AccountFragment
import com.example.audio.fragment.AddFragment
import com.example.audio.fragment.HomeFragment
import com.example.audio.fragment.SearchFragment
import com.example.audio.fragment.VideoFragment
import com.example.vinothLearningApp.R
import com.example.vinothLearningApp.databinding.ActivityDashBoardBinding

class DashBoardActivity : AppCompatActivity()
{
    lateinit var binding:ActivityDashBoardBinding
    var actionBarDrawerToggle: ActionBarDrawerToggle? = null


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val addFragment = AddFragment()
        val videoFragment = VideoFragment()
        val accountFragment = AccountFragment()

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.mainDrawer, R.string.open, R.string.close)

        binding.mainDrawer.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()

        setCurrentFragment(homeFragment)

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeItem->setCurrentFragment(homeFragment)
                R.id.search->setCurrentFragment(searchFragment)
                R.id.add->setCurrentFragment(addFragment)
                R.id.reels->setCurrentFragment(videoFragment)
                R.id.account->setCurrentFragment(accountFragment)
            }
            true
        }
        binding.sideMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeItem->setCurrentFragment(homeFragment)
                R.id.search->setCurrentFragment(searchFragment)
                R.id.add->setCurrentFragment(addFragment)
                R.id.reels->setCurrentFragment(videoFragment)
                R.id.account->setCurrentFragment(accountFragment)
            }
            return@setNavigationItemSelectedListener true
        }

    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_loader,fragment)
            commit()
//            overridePendingTransition(0,0)
        }
    }
}