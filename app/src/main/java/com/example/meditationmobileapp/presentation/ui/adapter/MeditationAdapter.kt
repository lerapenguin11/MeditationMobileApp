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

class MeditationAdapter : RecyclerView.Adapter<MeditationAdapter.MeditationViewHolder>(){

    private val meditationList = mutableListOf<Meditations>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeditationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_med, parent, false)

        return MeditationViewHolder(view)
    }

    override fun getItemCount(): Int = meditationList.size

    override fun onBindViewHolder(holder: MeditationViewHolder, position: Int) {
        val meditation = meditationList[position]
        holder.icon.setImageResource(meditation.meditations.icon)
        holder.title.setText(meditation.meditations.titleMed.toString())
        holder.time.setText(meditation.meditations.time)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(medList : List<Meditations>){
        meditationList.clear()
        meditationList.addAll(medList)
        notifyDataSetChanged()
    }

    class MeditationViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.tv_title_med)
        val icon : ImageView = view.findViewById(R.id.ic_icon_med)
        val time : TextView = view.findViewById(R.id.tv_time_med)
    }
}