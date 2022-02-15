package com.example.masthead

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlin.math.abs

/**
 * Created by sambuddha.dhar on 11/02/22.
 */
class MainActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener{
    private lateinit var appBar1: AppBarLayout
    private lateinit var appBar2: AppBarLayout
    private lateinit var tvCollapsable: TextView
    private lateinit var colorBG: View
    private lateinit var divider: View
    private var scrollRange = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//  set status text dark
        window.statusBarColor = ContextCompat.getColor(this,R.color.purple_700)
        val rv = findViewById<RecyclerView>(R.id.recyclerview)
        rv.layoutManager = LinearLayoutManager(this)
        appBar1 = findViewById(R.id.appBarLayout2)
        appBar2 = findViewById(R.id.appbarLayout)
        appBar1.addOnOffsetChangedListener(this)
        colorBG = findViewById(R.id.colorBG)
        divider = findViewById(R.id.divider)
        divider.alpha = 0.0f
        tvCollapsable = findViewById(R.id.tv_collapsable)
        val items = mutableListOf<String>()
        for (i in 0..50) {
            items.add("Item: $i")
        }
        rv.setHasFixedSize(true)
        rv.adapter = TestAdapter(items)

    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (scrollRange == -1) {
            scrollRange = appBarLayout?.totalScrollRange ?: -1
        }
        if (scrollRange + verticalOffset == 0) {
            colorBG.alpha = 0.0f
            appBar1.alpha = 0.0f
            appBar2.background = ContextCompat.getDrawable(this, R.color.white)
            divider.alpha = 1.0f
        } else {
            colorBG.alpha = (abs(verticalOffset + scrollRange) / (scrollRange * 1F))
            appBar1.alpha = (abs(verticalOffset + scrollRange) / (scrollRange * 1F))
            divider.alpha = 0.0f
            appBar2.background = ContextCompat.getDrawable(this, android.R.color.transparent)
        }
    }
}
