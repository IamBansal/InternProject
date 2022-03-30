package com.example.internproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internproject.R
import com.example.internproject.model.Item

class ItemAdapter(private var context: Context, private var list : ArrayList<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView) {
        var numText : TextView = itemView.findViewById(R.id.tvNumText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.numText.text = list[position].num.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

}