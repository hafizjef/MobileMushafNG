package com.hafizjef.mushafng.viewmodel

import com.github.nitrico.lastadapter.LastAdapter
import com.hafizjef.mushafng.BR
import com.hafizjef.mushafng.R
import com.hafizjef.mushafng.databinding.VerifyItemBinding
import com.hafizjef.mushafng.model.DataProvider
import com.hafizjef.mushafng.model.Group

class VerifyViewModel {
    private val mockObj = DataProvider.findAll()
    var onItemClickListener: OnItemClick? = null

    var adapter: LastAdapter = LastAdapter(mockObj, BR.item)
            .map<Group, VerifyItemBinding>(R.layout.verify_item) {
                onClick { onItemClickListener?.onClick(it.binding.item, it.adapterPosition) }
            }

    interface OnItemClick {
        fun onClick(item: Group, index: Int)
    }
}