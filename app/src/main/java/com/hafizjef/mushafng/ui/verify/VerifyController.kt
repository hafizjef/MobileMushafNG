package com.hafizjef.mushafng.ui.verify

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.hafizjef.mushafng.R
import com.hafizjef.mushafng.databinding.VerifyViewBinding
import com.hafizjef.mushafng.viewmodel.VerifyViewModel

class VerifyController : Controller() {

    lateinit var binding: VerifyViewBinding
    private val viewModel = VerifyViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.verify_view, container, false)
        binding.vm = viewModel
        return binding.root
    }

}