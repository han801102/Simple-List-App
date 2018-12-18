package com.example.han.techquiz.citytour

import android.util.Log
import com.example.han.techquiz.api.city.CityGuideApiClient
import com.example.han.techquiz.api.city.CityResponse
import com.example.han.techquiz.common.datamodel.BasicItem
import com.example.han.techquiz.common.datamodel.ImageItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class CityGuidePresenter {
    var cityGuideView: CityGuideView? = null
    var cityGuideApiClient = CityGuideApiClient()

    fun loadData() {
        var apiCall = cityGuideApiClient.getCityGuideApi().cities()
        apiCall.enqueue(object: Callback<List<CityResponse>> {
            override fun onFailure(call: Call<List<CityResponse>>, t: Throwable) {
                //TODO
            }

            override fun onResponse(call: Call<List<CityResponse>>, response: Response<List<CityResponse>>) {
                val data = ArrayList<Any>()
                response.body()?.forEach {
                    when (it.itemType) {
                        "basic" -> data.add(BasicItem(it.title, it.imageUrl, it.subTitle))
                        "single_image" -> data.add(ImageItem(it.imageUrl))
                    }
                }
                cityGuideView?.onLoadDataSuccess(data)
            }
        })
//
//        var data = ArrayList<Any>()
//        data.add(ImageItem("https://www.taipei-101.com.tw/upload/jn_now/201404/2014041217201090691882.jpg"))
//        cityGuideView?.onLoadDataSuccess(data)
    }
}