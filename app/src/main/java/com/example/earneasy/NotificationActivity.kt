package com.example.earneasy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earneasy.AdapterView.NotificatonAdapter
import com.example.earneasy.TestData.NotificationDataModelClass
import com.example.earneasy.TestData.TestData
import com.example.earneasy.VIewModels.MainActivityViewModel
import com.example.earneasy.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TestData.addtoNotificationList()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notification)

        binding.backtoMainfromPayment.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            finish()
        }

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getNotificationsList().observe(this){
            setRecycler(it)
        }


    }


    private fun setRecycler(it : List<NotificationDataModelClass>){
        val rv = binding.rvNotification
        rv.adapter = NotificatonAdapter(this,it)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}