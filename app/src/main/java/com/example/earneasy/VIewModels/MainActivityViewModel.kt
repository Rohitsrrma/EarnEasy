package com.example.earneasy.VIewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.earneasy.Repo.DataRepository
import com.example.earneasy.TestData.*

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    var repository : DataRepository?=null




    init {
        repository=DataRepository.getInstance()
    }




    fun getOffers() : MutableLiveData<List<OfferDataModelClass>>{
      return repository!!.getofferlist()
    }

    fun getExtraOffers() : MutableLiveData<MutableList<ExtraOfferDM>>{
        return repository!!.getExtraOfferList()
    }

    fun getHistoryList() : MutableLiveData<List<HistoryDataModelClass>>{
        return repository!!.getHistoryList()
    }

    fun getTransactionsList() : MutableLiveData<List<TransActionsDM>>{
        return repository!!.getTransactionsList()
    }
    fun getNotificationsList() : MutableLiveData<List<NotificationDataModelClass>>{
        return repository!!.getNotificationList()
    }


}