package com.hafizjef.mushafng.ui.report

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.hafizjef.mushafng.R
import com.hafizjef.mushafng.databinding.ReportViewBinding
import com.hafizjef.mushafng.ui.base.controller.withHorizontalTransaction
import com.hafizjef.mushafng.viewmodel.ReportViewModel

class ReportController : Controller() {

    lateinit var binding: ReportViewBinding
    private var viewModel = ReportViewModel()

    private val btnClickListener = object : ReportViewModel.OnItemClick {
        override fun onClick(v: View) {
            router.pushController(CreateReportController().withHorizontalTransaction())
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.report_view, container, false)

        binding.vm = viewModel
        viewModel.onBtnClick = btnClickListener

        return binding.root
    }

}