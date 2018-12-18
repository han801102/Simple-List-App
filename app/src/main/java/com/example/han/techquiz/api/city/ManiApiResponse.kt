package com.example.han.techquiz.api.city

import com.google.gson.annotations.SerializedName

class ManiApiResponse {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("item_type")
    var itemType: String = ""

    @SerializedName("title")
    var title: String = ""

    @SerializedName("sub_title")
    var subTitle: String = ""

    @SerializedName("image_url")
    var imageUrl: String = ""
}