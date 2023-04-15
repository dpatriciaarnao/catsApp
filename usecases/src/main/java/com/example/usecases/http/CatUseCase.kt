package com.example.usecases.http

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.entities.Cat
import com.example.entities.ObjectResult
import com.example.repository.remote.http.interfaces.ICatDataSource
import com.example.repository.remote.models.exception.NetworkException
import dagger.hilt.android.qualifiers.ApplicationContext

class CatUseCase(
    @ApplicationContext private val context: Context,
    private val catDataSource: ICatDataSource
) {

    private var _resultCats = MutableLiveData<List<Cat>>()
    var resultCats: MutableLiveData<List<Cat>> = _resultCats

    suspend fun getCats(): ObjectResult<List<Cat>> {
        return try {
            val result = catDataSource.getCats()
            if (result is ObjectResult.Failure && result.exception is NetworkException) {
                return result
            } else if (result is ObjectResult.Success) {
                _resultCats.value = result.data
            }
            return result
        } catch (e: java.lang.Exception) {
            ObjectResult.Failure(e)
        }
    }
}
