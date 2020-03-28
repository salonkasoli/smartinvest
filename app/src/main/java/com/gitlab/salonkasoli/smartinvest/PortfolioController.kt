package com.gitlab.salonkasoli.smartinvest

import android.app.Activity
import com.gitlab.salonkasoli.smartinvest.add.StockAddActivity

class PortfolioController (
    private val portfoliosWidget: PortfoliosWidget,
    private val activity: Activity
) {

    init {
        portfoliosWidget.fabClickListener = {
            activity.startActivity(StockAddActivity.intent(activity))
        }
    }
}