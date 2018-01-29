package com.hafizjef.mushafng.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.hafizjef.mushafng.R
import com.hafizjef.mushafng.databinding.DetailViewBinding
import com.hafizjef.mushafng.viewmodel.DetailViewModel

class DetailController(bundle: Bundle) : Controller(bundle) {
    companion object {
        val GROUP_INDEX_KEY = "groupIndex"
    }

    lateinit private var binding: DetailViewBinding
    private val viewModel = DetailViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_view, container, false)
        binding.vm = viewModel
        viewModel.groupIndex = args.getInt(GROUP_INDEX_KEY)
        return binding.root
    }
}