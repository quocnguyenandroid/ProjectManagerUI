package com.qndev.projectmanagerui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.qndev.projectmanagerui.R
import com.qndev.projectmanagerui.domain.OngoingDomain

class OngoingAdapter(private val items: MutableList<OngoingDomain>) :
    RecyclerView.Adapter<OngoingAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context).inflate(R.layout.viewholder_ongoing, parent, false)
        return ViewHolder((inflater))
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.date.text = items[position].date
        holder.progressBarPercent.text = items[position].progressPercent.toString() + "%"
        holder.progressBar.progress = items[position].progressPercent


        val drawableResourceId =
            holder.itemView.resources.getIdentifier(items[position].picPath, "drawable", context.packageName)
        holder.pic.load(drawableResourceId)

        if (position == 0) {
            holder.layout.setBackgroundResource(R.drawable.dark_background)
            holder.title.setTextColor(context.getColor(R.color.white))
            holder.date.setTextColor(context.getColor(R.color.white))
            holder.progress.setTextColor(context.getColor(R.color.white))
            holder.progressBarPercent.setTextColor(context.getColor(R.color.white))
            holder.pic.setColorFilter(ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_IN)
            holder.progressBar.progressTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.white))
        } else {
            holder.layout.setBackgroundResource(R.drawable.light_background)
            holder.title.setTextColor(context.getColor(R.color.dark_blue))
            holder.date.setTextColor(context.getColor(R.color.dark_blue))
            holder.progress.setTextColor(context.getColor(R.color.dark_blue))
            holder.progressBarPercent.setTextColor(context.getColor(R.color.dark_blue))
            holder.pic.setColorFilter(ContextCompat.getColor(context, R.color.dark_blue), PorterDuff.Mode.SRC_IN)
            holder.progressBar.progressTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.dark_blue))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleText)
        val layout: ConstraintLayout = itemView.findViewById(R.id.viewHolderLayout)
        val progress: TextView = itemView.findViewById(R.id.progressText)
        val date: TextView = itemView.findViewById(R.id.dateText)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val progressBarPercent: TextView = itemView.findViewById(R.id.percentText)
        val pic: ImageView = itemView.findViewById(R.id.pic)
    }

}