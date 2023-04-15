package com.example.presentation.views.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.example.catsapp.presentation.R
import com.example.catsapp.presentation.databinding.ActivitySplashBinding
import com.example.presentation.views.base.CatActivity
import com.example.presentation.views.ui.WelcomeCatsActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : CatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WelcomeCatsActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
