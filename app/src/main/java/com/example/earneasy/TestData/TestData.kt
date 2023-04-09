package com.example.earneasy.TestData

import com.example.earneasy.R

class TestData {
    companion object {
        var offerList = mutableListOf<OfferDataModelClass>()
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

        var extraofferlist = mutableListOf<ExtraOfferDM>()
        fun addtoExtraOfferList(){
            extraofferlist.add(ExtraOfferDM(R.drawable.referpersonthree))
            extraofferlist.add(ExtraOfferDM(R.drawable.gamezyoffer))
            extraofferlist.add(ExtraOfferDM(R.drawable.referfriend))

//            extraofferlist.add(ExtraOfferDM(1))
//            extraofferlist.add(ExtraOfferDM(2))
//            extraofferlist.add(ExtraOfferDM(3))
        }

        var notificationlist = mutableListOf<NotificationDataModelClass>()
        fun addtoNotificationList(){
            notificationlist.add(NotificationDataModelClass("7889182324"))
            notificationlist.add(NotificationDataModelClass("8283504335"))
            notificationlist.add(NotificationDataModelClass("8657452435"))

            notificationlist.add(NotificationDataModelClass("8872702002"))
        }

        var historyitemlist = mutableListOf<HistoryDataModelClass>()
        fun addtoHistoryList(){
            historyitemlist.add(HistoryDataModelClass("- ₹50 #EarnEasy","12 Dec 2022 12:20 PM","Checked",R.drawable.checked))
            historyitemlist.add(HistoryDataModelClass("- ₹50 #EarnEasy","1 Dec 2022 11:20 PM","Pending",R.drawable.pending))
            historyitemlist.add(HistoryDataModelClass("- ₹50 #EarnEasy","10 Dec 2022 1:20 AM","Checked",R.drawable.checked))
            historyitemlist.add(HistoryDataModelClass("- ₹50 #EarnEasy","10 Dec 2022 1:20 AM","Checked",R.drawable.checked))
            historyitemlist.add(HistoryDataModelClass("- ₹50 #EarnEasy","10 Dec 2022 1:20 AM","Pending",R.drawable.pending))
        }

        var transactionsList = mutableListOf<TransActionsDM>()

        fun addtoTransactionsList(){

            transactionsList.add(TransActionsDM("- ₹50 #EarnEasy","12 Dec 2022 12:20 PM","Checked",R.drawable.checked))
            transactionsList.add(TransActionsDM("- ₹50 #EarnEasy","1 Dec 2022 11:20 PM","Pending",R.drawable.pending))
            transactionsList.add(TransActionsDM("- ₹50 #EarnEasy","10 Dec 2022 1:20 AM","Checked",R.drawable.checked))
            transactionsList.add(TransActionsDM("- ₹50 #EarnEasy","10 Dec 2022 1:20 AM","Checked",R.drawable.checked))
            transactionsList.add(TransActionsDM("- ₹50 #EarnEasy","10 Dec 2022 1:20 AM","Pending",R.drawable.pending))

        }






    }
}