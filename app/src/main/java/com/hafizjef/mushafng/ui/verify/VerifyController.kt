package com.hafizjef.mushafng.ui.verify

import android.databinding.DataBindingUtil
import android.view.*
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
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.verify_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_refresh -> {
                viewModel.onClick(view!!)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}