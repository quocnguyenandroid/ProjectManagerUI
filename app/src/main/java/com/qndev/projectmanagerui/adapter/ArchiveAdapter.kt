package com.qndev.projectmanagerui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qndev.projectmanagerui.R

class ArchiveAdapter(private val items: MutableList<String>) : RecyclerView.Adapter<ArchiveAdapter.ViewHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context).inflate(R.layout.viewholder_archives, parent, false)
        return ViewHolder((inflater))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleText)

    }
}