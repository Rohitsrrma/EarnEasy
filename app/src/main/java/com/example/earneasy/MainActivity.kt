package com.example.earneasy

import android.annotation.SuppressLint
import android.app.Activity
import android.content.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.earneasy.Fragments.MainActivityFragments.*
import com.example.earneasy.Observers.ObserverMainActivity
import com.example.earneasy.TestData.TestData
import com.example.earneasy.VIewModels.MainActivityViewModel
import com.example.earneasy.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var navHostFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TestData.addtoExtraOfferList()
        TestData.addtoHistoryList()
        TestData.addtoTransactionsList()
        TestData.addtoNotificationList()

        auth = FirebaseAuth.getInstance()

        lifecycle.addObserver(ObserverMainActivity())
        Log.d("MAINs", "MainActi - ON CREATE   ")

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.MainActivityFragmentView) as NavHostFragment

        binding.BottomNavigationMain.setupWithNavController(navHostFragment.navController)

        binding.BottomNavigationMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.more_menu -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.MainActivityFragmentView, MoreFragment()
                    ).commit()
                }
                R.id.refer_menu -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.MainActivityFragmentView, ReferEarnFragment()
                    ).commit()
                }
                R.id.history_menu -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.MainActivityFragmentView, HistoryFragment()
                    ).commit()
                }
                R.id.home_menu -> {

                    supportFragmentManager.beginTransaction().replace(
                        R.id.MainActivityFragmentView, HomeFragment()
                    ).commit()

                }
            }
            true
        }

        setText()
    }

    companion object {
        @SuppressLint("SetTextI18n")
        fun setToolBar(position: Int, ctx: Context) {
            val TitleTV =
                (ctx as Activity).findViewById<TextView>(R.id.mainactivity_AppBarTitle_TextView)
            val IconIV = ctx.findViewById<ImageView>(R.id.mainactivity_AppBarTitle_ImageView)
            when (position) {

                0 -> {
                    TitleTV.text = "Rewards "
                    IconIV.setImageResource(R.drawable.rewardwheel)
                }
                1 -> {
                    TitleTV.text = "History"
                    IconIV.setImageResource(R.drawable.history2)
                }

                2 -> {
                    TitleTV.text = "Refer & Earn"
                    IconIV.setImageResource(R.drawable.send_money)
                }

                3 -> {
                    TitleTV.text = "More"
                    IconIV.setImageResource(R.drawable.more2)
                }

                4 -> {
                    TitleTV.text = "Payment"
                    IconIV.setImageResource(R.drawable.wallet)
                }
                5 -> {
                    TitleTV.text = "Profile"
                    IconIV.setImageResource(R.drawable.profle)
                }
                6 -> {
                    TitleTV.text = "Help & Support"
                    IconIV.setImageResource(R.drawable.support)
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()
        lifecycle.addObserver(ObserverMainActivity())
        Log.d("Mains", "Main Act  onResume:  ")
        setText()
    }


    fun setText() {
        binding.notificationcountTextView.text = TestData.notificationlist.size.toString()
    }

    fun Notify(view: View) {
        val intent = Intent(this, NotificationActivity::class.java)
        startActivity(intent)
    }

    fun taptocopy(view: View) {
        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val refertexttv = findViewById<TextView>(R.id.refferal_Code_TV)
        refertexttv.text = "nRjcCNfm"
        val text = refertexttv.text
        clipboard.setPrimaryClip(ClipData.newPlainText("label", text))
        Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_SHORT).show()
    }

    fun paymentFrag(view: View) {
        supportFragmentManager.beginTransaction().replace(
            R.id.MainActivityFragmentView, PaymentFragment()
        ).commit()
    }

    fun whatsapp(view: View) {
        sentIntent(this, "com.whatsapp", "Whatsapp")
    }

    fun instagram(view: View) {
        sentIntent(this, "com.instagram.android", "Instagram")
    }

    fun telegram(view: View) {
        sentIntent(this, "org.telegram.messenger", "Telegram")
    }

    fun morebutton(view: View) {
        more()
    }


    val shareText =
        "#EarnEasy: Earn Wallet Cash in 24hrs\n\nNew User Bonus Rs 50 on joining\n\n * Earn up to Rs 3000 every month\n\n Referral Code: nRjCcNfm\n\nDownload now from Google Play store\n\nClick on the link below:\n\nhttps://play.google.com/store/apps/details?id=com.earneasy.app"

    private fun sentIntent(context: Context, packageName: String, appName: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(
            Intent.EXTRA_TEXT, shareText
        )

        when (packageName) {
            "com.whatsapp" -> intent.setPackage(packageName)
            "com.instagram.android" -> intent.setPackage(packageName)
            "org.telegram.messenger" -> intent.setPackage(packageName)
            else -> {
                Toast.makeText(context, "$appName not installed", Toast.LENGTH_SHORT).show()
            }
        }

        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "$appName not installed", Toast.LENGTH_SHORT).show()
        }
    }


    @SuppressLint("QueryPermissionsNeeded")
    fun more() {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Share via"))
        } else {
            Toast.makeText(this, "No apps found to handle the share action", Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun dailyrewards(view: View) {
        val fragment = supportFragmentManager.findFragmentById(R.id.MainActivityFragmentView)
        if (fragment is HomeFragment) {
            val intent = Intent(this, DailyRewardsActivity::class.java)
            startActivity(intent)
        } else if (fragment is NavHostFragment) {
            val intent = Intent(this, DailyRewardsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.addObserver(ObserverMainActivity())
        Log.d("MAINs", "MainAct - ON Destroy")
    }

    override fun onPause() {
        super.onPause()
        lifecycle.addObserver(ObserverMainActivity())
        Log.d("MAINs","MainAct - ON Pause")
    }

    override fun onBackPressed() {
        var backPressedTime: Long = 0
        lateinit var toast: Toast
        toast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT)
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            toast.cancel()
        } else {
            toast.show()
        }
        backPressedTime = System.currentTimeMillis()
    }

}


