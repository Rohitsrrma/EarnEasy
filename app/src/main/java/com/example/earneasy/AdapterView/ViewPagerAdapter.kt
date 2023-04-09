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
import com.example.earneasy.R.id
import com.example.earneasy.TestData.ExtraOfferDM


class ViewPagerAdapter(val ctx: Context, val list: MutableList<ExtraOfferDM>) : RecyclerView.Adapter<ViewPagerAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager2imageview,parent,false)
        return Holder(view)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.ViewPagerIV.setImageResource(list[position].offerimage)
//        holder.ViewPagerIV.text =   list[position].offerimage.toString()
        holder.itemView.setOnClickListener {
            (ctx as MainActivity).supportFragmentManager.beginTransaction().replace(
                id.MainActivityFragmentView,
                ReferEarnFragment()
            ).commit()
        }


    }


    class Holder(item : View): ViewHolder(item) {
        val ViewPagerIV = item.findViewById<ImageView>(id.viewpagerreferfriendImageView)
//        val ViewPagerIV = item.findViewById<TextView>(id.viewpagerreferfriendImageView)
    }

    }



































class ViewPagerPaymentAdapter(fm:FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm,lifecycle) {
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


