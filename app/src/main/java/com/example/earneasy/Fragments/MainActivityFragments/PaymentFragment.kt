package com.example.earneasy.Fragments.MainActivityFragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.earneasy.AdapterView.ViewPagerPaymentAdapter
import com.example.earneasy.Fragments.PaymentActivityFragment.AddPaymentMethodFragment
import com.example.earneasy.Fragments.PaymentActivityFragment.TransactionsFragment
import com.example.earneasy.MainActivity
import com.example.earneasy.R
import com.example.earneasy.databinding.FragmentPaymentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PaymentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PaymentFragment : Fragment() {
    private lateinit var fContext: Context
    lateinit var viewPager2 : ViewPager2
    private lateinit var binding: FragmentPaymentBinding


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(inflater,R.layout.fragment_payment,container,false)
        // Inflate the layout for this fragment



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager2 = binding.root.findViewById(R.id.View_Pager_Payment)



        val adapter = ViewPagerPaymentAdapter(childFragmentManager,lifecycle)
        adapter.addFragments(AddPaymentMethodFragment())
        adapter.addFragments(TransactionsFragment())
        viewPager2.adapter = adapter
        viewPager2.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {

                super.onPageSelected(position)
                if (position==0){
                    tabSelect(true)
                } else{
                    tabSelect(false)
                }
            }

        })



        binding.paymentFragmentPaymentRequestTV.setOnClickListener {
            tabSelect(true)
            viewPager2.setCurrentItem(0)
        }

        binding.paymentFragmentTransactionsTV.setOnClickListener {
            tabSelect(false)
            viewPager2.setCurrentItem(1)

        }

        MainActivity.setToolBar(4,fContext)




    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fContext = context
    }

    fun tabSelect(isPRSelect:Boolean?=false){
        val prTv=binding.paymentFragmentPaymentRequestTV
        val trTv=binding.paymentFragmentTransactionsTV
        if (isPRSelect!!){
            prTv.apply {
                background=fContext.getDrawable(R.drawable.textroundbackgroud)
                setTextColor(fContext.getColor(R.color.white))
            }
            trTv.apply {
                background=null
                setTextColor(fContext.getColor(R.color.referbackground))
            }

        }else{
            prTv.apply {
                background=null
                setTextColor(fContext.getColor(R.color.referbackground))
            }
            trTv.apply {
                background=fContext.getDrawable(R.drawable.textroundbackgroud)
                setTextColor(fContext.getColor(R.color.white))
            }

        }
    }
}