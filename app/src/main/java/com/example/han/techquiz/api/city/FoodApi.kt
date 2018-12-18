package com.example.han.techquiz.api.city

import retrofit2.Call
import retrofit2.http.GET



interface FoodApi {
    @GET("/food.json")
    fun foods(): Call<List<ManiApiResponse>>
}