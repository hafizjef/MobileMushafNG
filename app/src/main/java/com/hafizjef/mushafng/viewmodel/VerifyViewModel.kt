package com.hafizjef.mushafng.viewmodel

import android.view.View
import com.github.nitrico.lastadapter.LastAdapter
import com.hafizjef.mushafng.BR
import com.hafizjef.mushafng.R
import com.hafizjef.mushafng.databinding.VerifyItemBinding
import com.hafizjef.mushafng.model.DataProvider
import com.hafizjef.mushafng.model.Group
import com.hafizjef.mushafng.model.WikiApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class VerifyViewModel {

    private var disposable: Disposable? = null
    private val wikiApi by lazy { WikiApiService.create() }


    private fun searchWiki(data: String) {
        disposable = wikiApi.hitCountCheck("query", "json", "search", data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> println(result.query.searchinfo.totalhits) },
                        { error -> println(error.message) }
                )
    }

    fun onClick(v: View) {
        searchWiki("test")
        print("------------ test message ----------")
    }


    private val mockObj = DataProvider.findAll()
    var onItemClickListener: OnItemClick? = null

    var adapter: LastAdapter = LastAdapter(mockObj, BR.item)
            .map<Group, VerifyItemBinding>(R.layout.verify_item) {
                onClick { onItemClickListener?.onClick(it.binding.item, it.adapterPosition) }
            }

    interface OnItemClick {
        fun onClick(item: Group?, index: Int)
    }
}