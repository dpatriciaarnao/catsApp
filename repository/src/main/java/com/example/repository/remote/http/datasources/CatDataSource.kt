package com.example.repository.remote.http.datasources

import com.example.entities.Cat
import com.example.entities.ObjectResult
import com.example.repository.remote.http.interfaces.ICatDataSource
import com.example.repository.remote.http.models.responses.toCatsList
import com.example.repository.remote.http.services.CatService
import com.example.repository.utils.retryIO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatDataSource(private val catService: CatService) : ICatDataSource {
    override suspend fun getCats(): ObjectResult<List<Cat>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = retryIO {
                    this@CatDataSource.catService.getCats()
                }
                if (!response.isSuccessful) {
                    ObjectResult.Failure(Exception(response.errorBody()?.toString()))
                } else {
                    ObjectResult.Success(response.body()?.toCatsList() ?: emptyList())
                }
            } catch (ex: Exception) {
                ObjectResult.Failure(ex)
            }
        }
    }
}
