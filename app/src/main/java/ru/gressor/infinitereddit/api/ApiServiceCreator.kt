package ru.gressor.infinitereddit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceCreator {

    fun getService(): ApiService = Retrofit.Builder()
        .baseUrl("https://www.reddit.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}