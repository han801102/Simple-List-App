package com.example.han.techquiz.citytour

import com.example.han.techquiz.api.city.CityGuideApi
import com.example.han.techquiz.api.city.MainApiClient
import com.example.han.techquiz.api.city.ManiApiResponse
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityGuidePresenterTest {

    @MockK
    lateinit var view: CityGuideView

    @MockK
    lateinit var mainApiClient: MainApiClient

    @InjectMockKs
    lateinit var cityGuidePresenter: CityGuidePresenter

    @MockK
    lateinit var cityGuideApi: CityGuideApi

    @MockK
    lateinit var apiCall: Call<List<ManiApiResponse>>

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
    }

    @Test
    fun loadData() {
        // given
        // stub api
        every {
            mainApiClient.getMainApi(CityGuideApi::class.java)
        } returns cityGuideApi
        every { cityGuideApi.cities() } returns apiCall

        // capture callback
        val slot = slot<Callback<List<ManiApiResponse>>>()

        // when
        cityGuidePresenter.loadData()

        // then
        verify {
            cityGuideApi.cities()
            apiCall.enqueue(capture(slot))
        }

        // stub response
        val response  = mockk<Response<List<ManiApiResponse>>>()
        every { response.body() } returns null
        slot.captured.onResponse(apiCall, response)
        verify {
            view.onLoadDataSuccess(any())
        }
    }
}