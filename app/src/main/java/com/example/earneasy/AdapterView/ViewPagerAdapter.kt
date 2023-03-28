package com.example.earneasy.AdapterView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.earneasy.Fragments.MainActivityFragments.ReferEarnFragment
import com.example.earneasy.MainActivity
import com.example.earneasy.R


class ViewPagerAdapter(val ctx: Context) : RecyclerView.Adapter<ViewPagerAdapter.Holder>() {
    protected var itemClickListener: ItemClickListener?=null

    class Holder(item : View): ViewHolder(item) {
        val ViewPagerIV = item.findViewById<ImageView>(com.example.earneasy.R.id.viewpagerreferfriendImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.earneasy.R.layout.viewpager2imageview,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {

        return 2
    }



    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.ViewPagerIV.setImageResource(com.example.earneasy.R.drawable.referfriend)
        holder.itemView.setOnClickListener {
            (ctx as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.MainActivityFragmentView,
                ReferEarnFragment()
            ).commit()


        }

    }
    interface ItemClickListener{
        fun onItemClick(view: View,position: Int)
    }

    fun setOnClickListener(listener: ItemClickListener){
        this.itemClickListener = listener
    }
}








class ViewPagerPaymentAdapter(fm:FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm,lifecycle) {
    var fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return fragments.size
    }



    override fun createFragment(position: Int): Fragment {
        /*when(position){
            0-> {fragments.add(AddPaymentMethodFragment())
                return AddPaymentMethodFragment()}
            1 ->{ fragments.add(TransactionsFragment())
         return TransactionsFragment()}
        }
        */
        return fragments[position]
    }


fun addFragments(fragment: Fragment){
    fragments.add(fragment)
}

}


