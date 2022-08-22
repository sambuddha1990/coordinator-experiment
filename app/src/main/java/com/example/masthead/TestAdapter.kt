package com.example.masthead

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.ITest

/**
 * Created by sambuddha.dhar on 11/02/22.
 */
class TestAdapter(val itemList: List<String>) : RecyclerView.Adapter<TestAdapter.TestVH>(), ITest {

    class TestVH(view: View) : RecyclerView.ViewHolder(view) {
        val tv = view.findViewById<TextView>(R.id.text)
        fun bind(item: String) {
            tv.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return TestVH(view)
    }

    override fun onBindViewHolder(holder: TestVH, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
    override fun test(): String = ""
    override fun test1(): Int = 1
    override fun test2(): Int = 1
    override fun test3(): Float = 1.0F

}