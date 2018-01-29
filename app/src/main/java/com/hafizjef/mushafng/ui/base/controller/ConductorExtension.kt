package com.hafizjef.mushafng.ui.base.controller

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler

fun Controller.withFadeTransaction(): RouterTransaction {
    return RouterTransaction.with(this)
            .pushChangeHandler(FadeChangeHandler())
            .popChangeHandler(FadeChangeHandler())
}

fun Controller.withHorizontalTransaction(): RouterTransaction {
    return RouterTransaction.with(this)
            .pushChangeHandler(HorizontalChangeHandler())
            .popChangeHandler(HorizontalChangeHandler())
}