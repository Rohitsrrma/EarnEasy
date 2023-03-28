package com.example.earneasy.TestData

import com.example.earneasy.R

class TestData {
    companion object {
        var offerList = mutableListOf<OfferDataModelClass>()

        var notificationlist = mutableListOf<NotificationDataModelClass>()

        var historyitemlist = mutableListOf<HistoryDataModelClass>()

        fun addtoHistoryList(){
            historyitemlist.add(HistoryDataModelClass("SignUP Bonus","12/02/2023","01:30 PM","50"))
            historyitemlist.add(HistoryDataModelClass("App Install Bonus","12/02/2023","01:30 PM","10"))
            historyitemlist.add(HistoryDataModelClass("Refferal Bonus","12/02/2023","01:30 PM","15"))
            historyitemlist.add(HistoryDataModelClass("Earning Amount Withdrawn","12/02/2023","01:30 PM","100"))
            historyitemlist.add(HistoryDataModelClass("Reward Amount Withdrawn","12/02/2023","01:30 PM","80"))
        }

        fun addtoNotificationList(){
            notificationlist.add(NotificationDataModelClass("7889182324"))
            notificationlist.add(NotificationDataModelClass("8283504335"))
            notificationlist.add(NotificationDataModelClass("8657452435"))

            notificationlist.add(NotificationDataModelClass("8872702002"))
        }

        fun addtoOfferList() {
            offerList.add(
                OfferDataModelClass(
                    R.drawable.rumyoffer,
                    R.drawable.gamezy_logo,
                    "RummyOffer"
                )
            )
            offerList.add(
                OfferDataModelClass(
                    R.drawable.ludooffer,
                    R.drawable.gamezy_logo,
                    "LudoOffer"
                )
            )
            offerList.add(
                OfferDataModelClass(
                    R.drawable.gamezyoffer,
                    R.drawable.gamezy_logo,
                    "GamezyOffer"
                )
            )
            offerList.add(
                OfferDataModelClass(
                    R.drawable.pokeroffer,
                    R.drawable.gamezy_logo,
                    "PokerOffer"
                )
            )
        }

    }
}