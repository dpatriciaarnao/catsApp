package com.example.presentation.views.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.presentation.views.viewmodels.CatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class CatFragment : Fragment() {
    private val rootViewModel by viewModels<CatViewModel>()

    fun getCatActivity(): CatActivity = requireActivity() as CatActivity

}
