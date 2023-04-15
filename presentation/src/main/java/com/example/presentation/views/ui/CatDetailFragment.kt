package com.example.presentation.views.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import com.example.catsapp.presentation.databinding.FragmentCatDetailBinding
import com.example.presentation.views.base.CatFragment
import com.example.presentation.views.viewmodels.CatViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CatDetailFragment : CatFragment() {

    private lateinit var binding: FragmentCatDetailBinding
    private val rootViewModel: CatViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.fragmentManager?.popBackStack()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatDetailBinding.inflate(inflater, container, false)
        initVariables()
        return binding.root
    }

    private fun initVariables() {
        //TODO

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.inclCatDetail.ivBackbutton.setOnClickListener {
            parentFragmentManager.popBackStack()
            requireActivity().onBackPressed()
        }
    }


    companion object {
        private const val CAT_SELECTED = "catSelected"
        val TAG = CatDetailFragment::javaClass.name
        fun newInstance(catSelected: String): CatDetailFragment =
            CatDetailFragment().also {
                it.arguments = Bundle().also { b -> b.putString(CAT_SELECTED, catSelected) }
            }
    }
}
