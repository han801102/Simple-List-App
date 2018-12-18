package com.example.han.techquiz.citytour

interface CityGuideView {
    fun onLoadDataSuccess(data: ArrayList<Any>)

    fun onLoadDataFailed()
}