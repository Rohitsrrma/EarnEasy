package com.example.earneasy

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.earneasy.Fragments.MainActivityFragments.HistoryFragment
import com.example.earneasy.Fragments.MainActivityFragments.HomeFragment
import com.example.earneasy.Fragments.MainActivityFragments.MoreFragment
import com.example.earneasy.Fragments.MainActivityFragments.ReferEarnFragment
import com.example.earneasy.Observers.ObserverMainActivity
import com.example.earneasy.TestData.TestData
import com.example.earneasy.VIewModelFactory.MainViewModelFactory
import com.example.earneasy.VIewModels.MainActivityViewModel
import com.example.earneasy.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var binding : ActivityMainBinding

    //val navController = navHostFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        lifecycle.addObserver(ObserverMainActivity())
        Log.d("MAINs"," - ON CREATE")

        mainActivityViewModel = ViewModelProvider(this,MainViewModelFactory()).get(MainActivityViewModel::class.java)



        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.MainActivityFragmentView) as NavHostFragment

       binding.BottomNavigationMain.setupWithNavController(navHostFragment.navController)









     binding.BottomNavigationMain.setOnItemSelectedListener (object : NavigationBarView.OnItemSelectedListener{
         override fun onNavigationItemSelected(item: MenuItem): Boolean {
             when(item.itemId){
                 R.id.more_menu->{
                     supportFragmentManager.beginTransaction().replace(R.id.MainActivityFragmentView,
                         MoreFragment()
                     ).commit()
                 }
                 R.id.refer_menu->{
                     supportFragmentManager.beginTransaction().replace(R.id.MainActivityFragmentView,
                         ReferEarnFragment()
                     ).commit()
                 }
                 R.id.history_menu->{
                     supportFragmentManager.beginTransaction().replace(R.id.MainActivityFragmentView,
                         HistoryFragment()
                     ).commit()
                 }
                 R.id.home_menu->{
                     supportFragmentManager.beginTransaction().replace(R.id.MainActivityFragmentView,
                         HomeFragment()
                     ).commit()
                 }
             }
             return true
         }
     })

        setText()
}


    companion object{

        fun setToolBar(position : Int,ctx : Context){
            val TitleTV = (ctx as Activity).findViewById<TextView>(R.id.mainactivity_AppBarTitle_TextView)
            val IconIV =  (ctx as Activity).findViewById<ImageView>(R.id.mainactivity_AppBarTitle_ImageView)
            when(position){

                0->{ TitleTV.text="Home"
                    IconIV.setImageResource(R.drawable.home)
            }
                1-> {  TitleTV.text ="History"
                    IconIV.setImageResource(R.drawable.history2)
                }

                2->{TitleTV.text="Refer & Earn"
                    IconIV.setImageResource(R.drawable.send_money)
                }

                3->{
                    TitleTV.text="More"
                    IconIV.setImageResource(R.drawable.more2)
                }

                4-> {
                    TitleTV.text="Payment"
                    IconIV.setImageResource(R.drawable.payment)
                }
                5-> {
                    TitleTV.text="Profile"
                    IconIV.setImageResource(R.drawable.profile)
                }
                6-> {
                    TitleTV.text="Help & Support"
                    IconIV.setImageResource(R.drawable.support)
                }

            }


        }


    }

    private var backPressedTime: Long = 0
    private lateinit var toast: Toast
    override fun onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            toast.cancel()
        } else {
            toast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT)
            toast.show()
        }
        backPressedTime = System.currentTimeMillis()


    }

    override fun onResume() {
        super.onResume()
        setText()
    }


    fun setText(){
        binding.notificationcountTextView.text = TestData.notificationlist.size.toString()
    }

    fun Notify(view: View) {
        val intent = Intent(this,NotificationActivity::class.java)
        startActivity(intent)
    }


}