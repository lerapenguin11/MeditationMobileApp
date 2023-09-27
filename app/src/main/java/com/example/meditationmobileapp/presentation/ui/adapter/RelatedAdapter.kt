package com.example.meditationmobileapp.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.meditationmobileapp.R
import com.example.meditationmobileapp.domain.entities.Meditations
import com.example.meditationmobileapp.presentation.ui.adapter.listener.RelatedListener

class RelatedAdapter(private val meditationList : List<Meditations>,
                        private val listener : RelatedListener) : RecyclerView.Adapter<RelatedAdapter.RelatedViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_med, parent, false)

        return RelatedViewHolder(view)
    }

    override fun getItemCount(): Int = meditationList.size

    override fun onBindViewHolder(holder: RelatedViewHolder, position: Int) {
        val meditation = meditationList[position]
        holder.icon.setImageResource(meditation.meditations.icon)
        holder.title.setText(meditation.meditations.titleMed)
        holder.time.setText(meditation.meditations.time)

        holder.itemView.setOnClickListener { listener.getRelated(meditation) }
    }

    class RelatedViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.tv_title_med)
        val icon : ImageView = view.findViewById(R.id.ic_icon_med)
        val time : TextView = view.findViewById(R.id.tv_time_med)
    }
}