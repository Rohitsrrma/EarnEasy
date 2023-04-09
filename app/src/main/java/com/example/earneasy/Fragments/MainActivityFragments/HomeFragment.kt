package com.example.earneasy.Fragments.MainActivityFragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.earneasy.AdapterView.HomeOfferRecyclerAdapter
import com.example.earneasy.AdapterView.ViewPagerAdapter
import com.example.earneasy.MainActivity.Companion.setToolBar
import com.example.earneasy.R
import com.example.earneasy.VIewModels.MainActivityViewModel
import com.example.earneasy.databinding.FragmentHomeBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var num: Int = 0
    private lateinit var fContext: FragmentActivity
    lateinit var binding: FragmentHomeBinding
    val handler=Handler()
    private lateinit var mainViewModel: MainActivityViewModel

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        viewPager2 = binding.root.findViewById(R.id.ReferVP)
        mainViewModel = MainActivityViewModel((fContext as Activity).application)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv = binding.root.findViewById<RecyclerView>(R.id.rvOffer)
        val noOffer = binding.root.findViewById<LinearLayout>(R.id.nooffer_ll)

        viewpager2()

        noOffer.visibility = View.INVISIBLE


        val data = mainViewModel.getOffers()
        data.observe(viewLifecycleOwner) {

            val offerRecyclerAdapter = HomeOfferRecyclerAdapter(fContext, it)
            rv.adapter = offerRecyclerAdapter
            rv.layoutManager = LinearLayoutManager(fContext, LinearLayoutManager.VERTICAL, false)

        }

        setToolBar(0, fContext)

    }




    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentActivity) {
            fContext = context
        }


    }

    override fun onPause() {
        super.onPause()


    }

    override fun onResume() {
        super.onResume()

    }




    @SuppressLint("NotifyDataSetChanged")




    fun viewpager2() {

        val extraofferData = mainViewModel.getExtraOffers()

        extraofferData.observe(viewLifecycleOwner) {
            val adapter = ViewPagerAdapter(fContext, it)
            viewPager2.adapter = adapter

            val sliderrunnable = Runnable {
                if(viewPager2.currentItem<it.size-1){

                    viewPager2.currentItem=viewPager2.currentItem+1

                } else {
                    viewPager2.setCurrentItem(0,true)
                }
            }
            val sliderbackward = Runnable { viewPager2.currentItem=viewPager2.currentItem-2 }



            handler.removeCallbacks(sliderrunnable)


            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)


                    handler.postDelayed(sliderrunnable,1500)







                }
            })


            viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        }
    }


}








