package com.natashaval.futuredatabinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet:Array<String>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)
    }
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int){
        viewHolder.textView.text = dataSet[position]
    }
}