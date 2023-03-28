package com.example.earneasy.Fragments.PaymentActivityFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.earneasy.R
import com.example.earneasy.databinding.FragmentAddPaymentMethodBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var fContext : Context


/**
 * A simple [Fragment] subclass.
 * Use the [AddPaymentMethodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddPaymentMethodFragment : Fragment() {


    private var param1: String? = null

    private var param2: String? = null
    private lateinit var binding : FragmentAddPaymentMethodBinding





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
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_payment_method,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RewardRequestTV.setOnClickListener {
            Toast.makeText(fContext, "You Need minimum ₹ 200 to withdraw reward amount", Toast.LENGTH_SHORT).show()
        }
        binding.EarningRequestTV.setOnClickListener {
                Toast.makeText(fContext, "You Need minimum ₹ 50 to withdraw earning amount", Toast.LENGTH_SHORT).show()

        }
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
         * @return A new instance of fragment AddPaymentMethodFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddPaymentMethodFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}