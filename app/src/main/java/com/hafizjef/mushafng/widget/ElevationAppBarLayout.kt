package com.hafizjef.mushafng.widget

import android.animation.ObjectAnimator
import android.animation.StateListAnimator
import android.content.Context
import android.os.Build
import android.support.design.R
import android.support.design.widget.AppBarLayout
import android.util.AttributeSet

class ElevationAppBarLayout @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : AppBarLayout(context, attrs) {

    private var origStateAnimator: StateListAnimator? = null

    init {
        if (Build.VERSION.SDK_INT >= 21) {
            origStateAnimator = stateListAnimator
        }
    }

    fun enableElevation() {
        if (Build.VERSION.SDK_INT >= 21) {
            stateListAnimator = origStateAnimator
        }
    }

    fun disableElevation() {
        if (Build.VERSION.SDK_INT >= 21) {
            stateListAnimator = StateListAnimator().apply {
                val objAnimator = ObjectAnimator.ofFloat(this, "elevation", 0f)

                // Enabled and collapsible, but not collapsed means not elevated
                addState(intArrayOf(android.R.attr.enabled, R.attr.state_collapsible, -R.attr.state_collapsed),
                        objAnimator)

                // Default enabled state
                addState(intArrayOf(android.R.attr.enabled), objAnimator)

                // Disabled state
                addState(IntArray(0), objAnimator)
            }
        }
    }

}