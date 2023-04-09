package com.example.earneasy.Fragments.MainActivityFragments


import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.earneasy.*
import com.example.earneasy.databinding.FragmentMoreBinding


/**
 * A simple [Fragment] subclass.
 * Use the [MoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoreFragment : Fragment() {
    private lateinit var fContext: Context
    private lateinit var binding: FragmentMoreBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        binding = FragmentMoreBinding.inflate(inflater,container,false)
//        val navHostFragment = NavHostFragment()
//        val navController = navHostFragment.navController
//        val payment  = binding.PaymentTabLL
//        payment.setOnClickListener {
//            navController.navigate(R.id.paymentFragment)
//        }

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_more, container, false)






        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MainActivity.setToolBar(3, fContext)


        binding.PaymentTabLL.setOnClickListener {

            (fContext as MainActivity).supportFragmentManager.beginTransaction().replace(
                R.id.MainActivityFragmentView,
                PaymentFragment()
            ).commit()

        }
        binding.helpsupportLL.setOnClickListener {

            (fContext as MainActivity).supportFragmentManager.beginTransaction().replace(
                R.id.MainActivityFragmentView,
                HelpSupportFragment()
            ).commit()

        }

        binding.ProfileLL.setOnClickListener {
            (fContext as MainActivity).supportFragmentManager.beginTransaction().replace(
                R.id.MainActivityFragmentView,
                ProfileFragment()
            ).commit()
        }
        binding.Rateus.setOnClickListener {
            val dialog = Dialog(fContext)
            dialog.setContentView(R.layout.dialog_rateus)
            val width = Resources.getSystem().displayMetrics.widthPixels

            dialog.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.show()
            val close_button = dialog.findViewById<ImageView>(R.id.close_button)
            close_button.setOnClickListener {
                dialog.dismiss()
            }
        }
        binding.faq.setOnClickListener {
            val intent = Intent(fContext, HowDoesThisWork::class.java)
            startActivity(intent)
        }

        binding.logout.setOnClickListener {
            val dialog = Dialog(fContext)
            dialog.setContentView(R.layout.logout_dialog)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.show()
            val cancel = dialog.findViewById<TextView>(R.id.cancelLogout)
            val ok = dialog.findViewById<TextView>(R.id.ok)
            cancel.setOnClickListener {
                dialog.dismiss()
            }
            ok.setOnClickListener {
                dialog.dismiss()
                val intent = Intent(fContext,GetStartedActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fContext = context
    }

}