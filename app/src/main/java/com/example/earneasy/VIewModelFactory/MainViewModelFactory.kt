package com.example.earneasy.VIewModelFactory



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.earneasy.VIewModels.MainActivityViewModel



class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel() as T

    }
}