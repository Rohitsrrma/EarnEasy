package com.example.earneasy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.earneasy.databinding.ActivityHowDoesThisWorkBinding

class HowDoesThisWork : AppCompatActivity() {
    private lateinit var binding : ActivityHowDoesThisWorkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_how_does_this_work)
        binding.backtoMainfromPayment.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            finish()
        }




    }
}