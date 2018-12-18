package com.example.han.techquiz.api.city

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CityGuideApiClient {

    fun getCityGuideApi(): CityGuideApi {
        return Retrofit.Builder()
            .baseUrl("https://tech-35854.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CityGuideApi::class.java)
    }
}