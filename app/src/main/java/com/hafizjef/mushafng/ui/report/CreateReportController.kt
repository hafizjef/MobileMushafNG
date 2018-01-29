package com.hafizjef.mushafng.ui.report

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.hafizjef.mushafng.R
import com.hafizjef.mushafng.databinding.CreateReportViewBinding

class CreateReportController : Controller() {

    lateinit var binding: CreateReportViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.create_report_view, container, false)
        return binding.root
    }

}