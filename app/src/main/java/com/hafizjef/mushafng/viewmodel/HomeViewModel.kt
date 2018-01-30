package com.hafizjef.mushafng.viewmodel

import android.content.Intent
import android.net.Uri
import android.view.View
import com.github.nitrico.lastadapter.LastAdapter
import com.hafizjef.mushafng.BR
import com.hafizjef.mushafng.R
import com.hafizjef.mushafng.databinding.HomeItemBinding
import com.hafizjef.mushafng.model.DataProvider
import com.hafizjef.mushafng.model.Group

class HomeViewModel {
    private val githubUrl = "https://github.com/putraxor/ConductorMVVM"
    private val groups = DataProvider.findAll()
    var onItemClickListener: OnItemClick? = null

    var adapter: LastAdapter = LastAdapter(groups, BR.item)
            .map<Group, HomeItemBinding>(R.layout.home_item) {
                onClick { onItemClickListener?.onClick(it.binding.item, it.adapterPosition) }
            }

    /**
     * ViewSource event listener
     */
    fun onClickViewSource(v: View) {
        val browser = Intent(Intent.ACTION_VIEW)
        browser.data = Uri.parse(githubUrl)
        v.context.startActivity(browser)
    }

    /**
     * Simple comunnicator between ViewModel to View
     */
    interface OnItemClick {
        fun onClick(item: Group?, index: Int)
    }
}