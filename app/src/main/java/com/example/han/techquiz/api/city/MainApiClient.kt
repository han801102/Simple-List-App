package com.example.han.techquiz.api.city

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainApiClient {

    fun <T> getMainApi(api: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl("https://tech-35854.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(api)
    }
}