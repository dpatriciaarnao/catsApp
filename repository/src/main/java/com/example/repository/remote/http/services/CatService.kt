package com.example.repository.remote.http.services

import com.example.repository.remote.http.models.responses.CatResponseItem
import com.example.repository.utils.DynamicProperties
import retrofit2.Response
import retrofit2.http.GET

interface CatService {

    @GET(DynamicProperties.DEFAULT_BASE_URL+"breeds")
    suspend fun getCats(): Response<List<CatResponseItem>>
}
