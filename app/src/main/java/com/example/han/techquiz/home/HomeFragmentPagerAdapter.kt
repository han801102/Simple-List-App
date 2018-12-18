package com.example.han.techquiz.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.han.techquiz.citytour.CityGuideFragment
import com.example.han.techquiz.food.FoodFragment
import com.example.han.techquiz.shop.ShopFragment
import java.lang.Exception

class HomeFragmentPagerAdapter(fragmentManager: FragmentManager?) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> CityGuideFragment.newInstance()
            1 -> ShopFragment.newInstance()
            2 -> FoodFragment.newInstance()
            else -> throw Exception("Not defined position")
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "CITY GUIDE"
            1 -> "SHOP"
            2 -> "EAT"
            else -> throw Exception("Not defined position")
        }
    }
}