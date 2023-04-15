package com.example.presentation.views.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.KeyEvent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.views.viewmodels.CatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class CatActivity(
) : AppCompatActivity() {

    private val viewModel: CatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
            }
            KeyEvent.KEYCODE_VOLUME_UP -> {
            }
            else -> return super.onKeyDown(keyCode, event)
        }
        return true
    }
}
