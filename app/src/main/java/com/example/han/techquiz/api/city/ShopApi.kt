package com.example.han.techquiz.api.city

import retrofit2.Call
import retrofit2.http.GET



interface ShopApi {
    @GET("/shop.json")
    fun shops(): Call<List<ManiApiResponse>>
}