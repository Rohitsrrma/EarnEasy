package com.example.earneasy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earneasy.AdapterView.NotificatonAdapter
import com.example.earneasy.TestData.TestData
import com.example.earneasy.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TestData.addtoNotificationList()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notification)
        binding.notificationcountTextView.text = TestData.notificationlist.size.toString()
        binding.backtoMainfromPayment.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            finish()
        }
        setRecycler()
    }


    fun setRecycler(){
        val rv = binding.rvNotification
        rv.adapter = NotificatonAdapter(this,TestData.notificationlist)
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}