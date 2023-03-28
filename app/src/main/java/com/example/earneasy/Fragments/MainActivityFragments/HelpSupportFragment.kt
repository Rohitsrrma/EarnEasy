package com.example.earneasy.Fragments.MainActivityFragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.earneasy.MainActivity
import com.example.earneasy.R
import com.example.earneasy.databinding.FragmentHelpSupportBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HelpSupportFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HelpSupportFragment : Fragment() {
    // TODO: Rename and change types of parameters


    private lateinit var fContext: Context
    private lateinit var binding :FragmentHelpSupportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_help_support,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MainActivity.setToolBar(6,fContext)




    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fContext= context
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HelpSupportFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HelpSupportFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}