package com.gitlab.salonkasoli.smartinvest.add

class StockAddController (
    private val widget: StockAddWidget
) {

    init {
        widget.tickerClickListener = {
            widget.setTicker("KO")
        }
    }
}