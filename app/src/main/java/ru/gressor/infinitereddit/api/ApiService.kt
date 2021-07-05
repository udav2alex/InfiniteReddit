package ru.gressor.infinitereddit.api

import retrofit2.http.GET
import ru.gressor.infinitereddit.api.entities.Response

interface ApiService {
    @GET("hot.json")
    suspend fun getResponse(): Response
}