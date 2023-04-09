package com.example.earneasy.AdapterView

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.earneasy.OfferExplainedActivity
import com.example.earneasy.R
import com.example.earneasy.TestData.OfferDataModelClass

class HomeOfferRecyclerAdapter(val ctx: Context, val list:List<OfferDataModelClass> ) :
    RecyclerView.Adapter<HomeOfferRecyclerAdapter.Holder>() {

    class Holder(itemView: View) : ViewHolder(itemView) {
        var backgroudthumb = itemView.findViewById<ImageView>(R.id.backgroudthumb)
        var thumb = itemView.findViewById<ImageView>(R.id.offerimagethumb)
        var offername = itemView.findViewById<TextView>(R.id.offername)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.offer_item_view,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
    holder.backgroudthumb.setImageResource(list[position].backgroudthumb)
    holder.thumb.setImageResource(list[position].thumb)
        holder.offername.text = list[position].offername
        holder.itemView.setOnClickListener {
            val intent = Intent(ctx,OfferExplainedActivity::class.java)
            ctx.startActivity(intent)
        }

    }


}