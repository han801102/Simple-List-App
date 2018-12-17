package com.example.han.techquiz.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.han.techquiz.R
import com.google.android.material.tabs.TabLayout

/**
 * A fragment with tab swipe layout
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager(view)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDetach() {
        super.onDetach()
    }

    fun initViewPager(view: View) {
        var viewPager = view.findViewById<ViewPager>(R.id.view_pager)
        var pagerAdapter = HomeFragmentPagerAdapter(fragmentManager)
        viewPager.adapter = pagerAdapter
        var tabLayout = view.findViewById<TabLayout>(R.id.sliding_tabs)
        tabLayout.setupWithViewPager(viewPager)
    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

}
