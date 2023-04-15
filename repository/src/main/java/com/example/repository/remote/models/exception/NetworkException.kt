package com.example.repository.remote.models.exception

import com.google.gson.Gson
import okhttp3.ResponseBody
import java.io.IOException

class NetworkException(message: String) : IOException(message)

data class CatError(override val message: String) : Exception(message)

fun ResponseBody?.toCatError(): CatError {
    return if (this == null) {
        CatError("Error with empty response body")
    } else {
        val errorBodyStr = this.string()
        Gson().fromJson(errorBodyStr, CatError::class.java)
    }
}
