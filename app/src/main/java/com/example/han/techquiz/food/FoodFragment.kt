package com.example.han.techquiz.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.han.techquiz.R
import com.example.han.techquiz.home.DynamicItemAdapter

/**
 * A fragment representing a city guide list.
 */
class FoodFragment : Fragment(), FoodView {
    private var cityGuideAdapter = DynamicItemAdapter()
    private var cityGuidePresenter = FoodPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityGuidePresenter.foodView = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_cityguide_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)
    }

    override fun onResume() {
        super.onResume()
        cityGuidePresenter.loadData()
    }

    override fun onLoadDataSuccess(data: ArrayList<Any>) {
        cityGuideAdapter.data = data
        cityGuideAdapter.notifyDataSetChanged()
    }

    override fun onLoadDataFailed() {
        // TODO: Handle errors
    }

    private fun initRecyclerView(view: View) {
        view.findViewById<RecyclerView>(R.id.list).adapter = cityGuideAdapter
    }

    companion object {
        fun newInstance() = FoodFragment()
    }
}
