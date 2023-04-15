package com.example.presentation.views.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entities.Cat
import com.example.entities.ObjectResult
import com.example.repository.remote.http.models.responses.CatResponseItem
import com.example.usecases.http.CatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val catUseCase: CatUseCase,
) : ViewModel() {

    private val _catsData = MutableLiveData<List<Cat>?>()
    val catsData: MutableLiveData<List<Cat>?> = _catsData

    private val _viewState = MutableLiveData<CatsViewState>()
    val viewState: LiveData<CatsViewState> = _viewState

    fun loadDataCats() {
        viewModelScope.launch {
            when (val result = catUseCase.getCats()) {
                is ObjectResult.Success -> {
                    _viewState.value = CatsViewState.LoadData.Success(
                        cats = result.data
                    )
                    _catsData.value = result.data
                }

                is ObjectResult.Failure -> {
                    _viewState.value = CatsViewState.LoadData.Failure(result.exception)
                }

                else -> {}
            }
        }
    }

}

sealed class CatsViewState {
    sealed class LoadData : CatsViewState() {
        object Processing : LoadData()
        data class Success(val cats: List<Cat>) : LoadData()
        data class Failure(val error: Throwable) : LoadData()
    }
}


