package com.example.han.techquiz.api.city

import retrofit2.Call
import retrofit2.http.GET



interface CityGuideApi {
    @GET("/city.json")
    fun cities(): Call<List<CityResponse>>
}