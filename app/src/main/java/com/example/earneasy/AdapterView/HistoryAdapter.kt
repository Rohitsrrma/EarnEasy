package com.example.earneasy.AdapterView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.earneasy.R
import com.example.earneasy.TestData.HistoryDataModelClass

class HistoryAdapter(val list: List<HistoryDataModelClass>) : RecyclerView.Adapter<HistoryAdapter.Holder>() {
    class Holder(itemView : View) :ViewHolder(itemView){

        val signup = itemView.findViewById<TextView>(R.id.signup_bonus_text)
        val reward_signup = itemView.findViewById<TextView>(R.id.histroyamount)
        val date = itemView.findViewById<TextView>(R.id.Date)
        val time = itemView.findViewById<TextView>(R.id.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
  val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item_view,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.signup.text = list[position].title
        holder.reward_signup.text = "₹"+ list[position].amount
        holder.date.text = "Date :"+list[position].date
        holder.time.text = "Time :"+list[position].time
    }
}