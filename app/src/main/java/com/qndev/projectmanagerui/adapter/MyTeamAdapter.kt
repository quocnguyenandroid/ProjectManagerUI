package com.qndev.projectmanagerui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qndev.projectmanagerui.R
import com.qndev.projectmanagerui.domain.TeamDomain

class MyTeamAdapter(private val items: MutableList<TeamDomain>) : RecyclerView.Adapter<MyTeamAdapter.ViewHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context).inflate(R.layout.viewholder_my_team, parent, false)
        return ViewHolder((inflater))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.status.text = items[position].title
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleText)
        val status: TextView = itemView.findViewById(R.id.statusText)

    }
}