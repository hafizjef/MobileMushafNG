package com.hafizjef.mushafng.viewmodel

import android.view.View

class ReportViewModel {

    var onBtnClick: OnItemClick? = null

    interface OnItemClick {
        fun onClick(v: View)
    }
}