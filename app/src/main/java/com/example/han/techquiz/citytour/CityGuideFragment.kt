package com.example.han.techquiz.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.han.techquiz.R

/**
 * A fragment representing a city guide list.
 */
class CityGuideFragment : Fragment() {
    private var cityGuideAdapter = DynamicItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_cityguide_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)
    }

    private fun initRecyclerView(view: View) {
        view.findViewById<RecyclerView>(R.id.list).adapter = cityGuideAdapter
    }

    companion object {
        fun newInstance() = CityGuideFragment()
    }
}
