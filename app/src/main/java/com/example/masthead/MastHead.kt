package com.example.masthead

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.appbar.AppBarLayout

/**
 * Created by sambuddha.dhar on 11/02/22.
 */
class MastHead @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppBarLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.test_layout, this)
        val container = this.findViewById<FrameLayout>(R.id.masthead_container)
        val view = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            text = "Dynamic text"
            gravity = Gravity.CENTER
        }
        container.addView(view)
    }

}