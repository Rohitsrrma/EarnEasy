package com.example.earneasy.Observers

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ObserverMainActivity : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.d("MAINs","Observer - ON CREATE")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.d("MAINs","Observer - ON Resume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onPause(){
        Log.d("MAINs","Observer - ON Pause")
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.d("MAINs","Observer - ON Destroy")
    }


}