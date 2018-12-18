package com.example.han.techquiz.food

interface FoodView {
    fun onLoadDataSuccess(data: ArrayList<Any>)

    fun onLoadDataFailed()
}