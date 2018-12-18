package com.example.han.techquiz.shop

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
class ShopFragment : Fragment(), ShopView {
    private var dynamicItemAdapter = DynamicItemAdapter()
    private var shopPresenter = ShopPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shopPresenter.shopView = this
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
        shopPresenter.loadData()
    }

    override fun onLoadDataSuccess(data: ArrayList<Any>) {
        dynamicItemAdapter.data = data
        dynamicItemAdapter.notifyDataSetChanged()
    }

    override fun onLoadDataFailed() {
        // TODO: Handle errors
    }

    private fun initRecyclerView(view: View) {
        view.findViewById<RecyclerView>(R.id.list).adapter = dynamicItemAdapter
    }

    companion object {
        fun newInstance() = ShopFragment()
    }
}
