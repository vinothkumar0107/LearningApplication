package com.example.audio.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.vinothLearningApp.R
import com.example.vinothLearningApp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity()
{
    lateinit var bindig:ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivitySplashBinding.inflate(layoutInflater)
        var view = bindig.root
        setContentView(view)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}