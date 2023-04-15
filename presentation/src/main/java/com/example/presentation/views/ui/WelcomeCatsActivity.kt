package com.example.presentation.views.ui

import android.location.LocationListener
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.catsapp.presentation.R
import com.example.catsapp.presentation.databinding.ActivityCatsBinding
import com.example.entities.Cat
import com.example.presentation.views.adapters.CatsAdapterList
import com.example.presentation.views.base.CatActivity
import com.example.presentation.views.viewmodels.CatViewModel
import com.example.presentation.views.viewmodels.CatsViewState


class WelcomeCatsActivity : CatActivity() {

    private lateinit var binding: ActivityCatsBinding
    private val rootViewModel: CatViewModel by viewModels()
    private lateinit var catsAdapter: CatsAdapterList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cats)
        binding.lifecycleOwner = this
        initialize()
    }

    fun initialize() {

        catsAdapter = CatsAdapterList(
            object : CatsAdapterList.CatsAdapterListListener {
                override fun onClickDetail(cat: Cat) {
                    val catSelected = cat.name
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.add(
                        R.id.container,
                        CatDetailFragment.newInstance(catSelected)
                    ).commit()
                }
            }
        )

        binding.recyclerViewCats.adapter = catsAdapter
        binding.recyclerViewCats.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        initObserver()
        rootViewModel.loadDataCats()
    }

    fun initObserver() {
        rootViewModel.viewState.observe(this) {
            when (it) {
                is CatsViewState.LoadData.Failure -> {
                    //TODO
                }

                CatsViewState.LoadData.Processing -> {
                    //TODO
                }

                is CatsViewState.LoadData.Success -> {
                    catsAdapter.submitList(it.cats)
                }
            }
        }
    }

    override fun onBackPressed() {
        val fragment = this.supportFragmentManager.findFragmentById(R.id.main_container)
        (fragment as? IOnBackPressed)?.onBackPressed()?.not()?.let { isCanceled: Boolean ->
            if (!isCanceled) super.onBackPressed()
        }
    }

    interface IOnBackPressed {
        fun onBackPressed(): Boolean
    }
}
