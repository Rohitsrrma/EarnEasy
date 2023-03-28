package com.example.earneasy.Fragments.MainActivityFragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.earneasy.AdapterView.HomeOfferRecyclerAdapter
import com.example.earneasy.AdapterView.ViewPagerAdapter
import com.example.earneasy.MainActivity.Companion.setToolBar
import com.example.earneasy.R
import com.example.earneasy.TestData.TestData
import com.example.earneasy.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var fContext: Context
    lateinit var binding : FragmentHomeBinding



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        // Inflate the layout for this fragment
        viewPager2 = binding.root.findViewById(R.id.ReferVP)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv =  binding.root.findViewById<RecyclerView>(R.id.rvOffer)
        val noOffer =  binding.root.findViewById<LinearLayout>(R.id.nooffer_ll)

        TestData.addtoOfferList()



        noOffer.visibility= View.INVISIBLE


        val adapter = ViewPagerAdapter(fContext)
        viewPager2.adapter = adapter
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL







        val offerRecyclerAdapter = HomeOfferRecyclerAdapter(TestData.offerList)
        rv.adapter=offerRecyclerAdapter
        rv.layoutManager = LinearLayoutManager(fContext, LinearLayoutManager.VERTICAL, false)
        setToolBar(0,fContext)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fContext = context
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }





}