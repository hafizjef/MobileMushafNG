package com.hafizjef.mushafng.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.bluelinelabs.conductor.changehandler.VerticalChangeHandler
import com.hafizjef.mushafng.R
import com.hafizjef.mushafng.databinding.HomeViewBinding
import com.hafizjef.mushafng.model.Group
import com.hafizjef.mushafng.viewmodel.HomeViewModel

class HomeController : Controller() {

    lateinit private var binding: HomeViewBinding
    private val viewModel = HomeViewModel()

    /**
     * Home last adapter item click listener
     */
    private val itemClickListener = object : HomeViewModel.OnItemClick {
        override fun onClick(item: Group, index: Int) {
            val bundle = Bundle()
            bundle.putInt(DetailController.GROUP_INDEX_KEY, index)
            val transaction = RouterTransaction
                    .with(DetailController(bundle))
                    .pushChangeHandler(FadeChangeHandler())
                    .popChangeHandler(VerticalChangeHandler())
            router.pushController(transaction)
        }
    }

    /**
     * Inflate view with databinding
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_view, container, false)
        binding.vm = viewModel
        viewModel.onItemClickListener = itemClickListener
        return binding.root
    }
}