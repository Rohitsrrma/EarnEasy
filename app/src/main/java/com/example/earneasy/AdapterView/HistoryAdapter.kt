package com.example.earneasy.AdapterView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.earneasy.R
import com.example.earneasy.TestData.HistoryDataModelClass

class HistoryAdapter(val list: List<HistoryDataModelClass>) : RecyclerView.Adapter<HistoryAdapter.Holder>() {
    class Holder(itemView : View) :ViewHolder(itemView){

        val historyearn = itemView.findViewById<TextView>(R.id.historyearn)
        val historydate = itemView.findViewById<TextView>(R.id.historydate)
        val completed = itemView.findViewById<TextView>(R.id.historycomplete)
        val historyimage = itemView.findViewById<ImageView>(R.id.historyiv)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item_view,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.historydate.text = list[position].date
        holder.historyearn.text =  list[position].earn
        holder.historyimage.setImageResource(list[position].image)
        holder.completed.text = list[position].completed

    }
}