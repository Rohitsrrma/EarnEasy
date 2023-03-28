package com.example.earneasy.AdapterView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.earneasy.R
import com.example.earneasy.TestData.NotificationDataModelClass

class NotificatonAdapter(ctx : Context,val list: List<NotificationDataModelClass>) : RecyclerView.Adapter<NotificatonAdapter.Holder>() {
    class Holder(itemView : View) : ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.numberTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context,).inflate(R.layout.notification_item_view,parent,false)
        return Holder(view)

    }

    override fun getItemCount(): Int {

       return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
      holder.title.text = "Your Friend - "+list[position].title+" \nJoined EarnEasy"


    }
}