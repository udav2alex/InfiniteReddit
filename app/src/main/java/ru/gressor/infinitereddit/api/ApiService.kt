package ru.gressor.infinitereddit.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.gressor.infinitereddit.api.entities.Response

interface ApiService {
    @GET("hot.json")
    suspend fun getResponse(): Response

    @GET("hot.json")
    suspend fun getPagedResponse(@Query("after") after: String): Response
}