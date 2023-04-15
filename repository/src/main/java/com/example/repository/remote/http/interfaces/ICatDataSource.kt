package com.example.repository.remote.http.interfaces

import com.example.entities.Cat
import com.example.entities.ObjectResult


interface ICatDataSource {
    suspend fun getCats(): ObjectResult<List<Cat>>
}
