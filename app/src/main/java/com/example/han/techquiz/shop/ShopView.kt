package com.example.han.techquiz.shop

interface ShopView {
    fun onLoadDataSuccess(data: ArrayList<Any>)

    fun onLoadDataFailed()
}