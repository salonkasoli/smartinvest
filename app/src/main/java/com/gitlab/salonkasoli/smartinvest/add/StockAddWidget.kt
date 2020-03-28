package com.gitlab.salonkasoli.smartinvest.add

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.gitlab.salonkasoli.smartinvest.R
import kotlinx.android.synthetic.main.activity_add_stock.view.*

class StockAddWidget(
    layout: View
) {

    var tickerClickListener: (() -> Unit)? = null

    private val tickerLayout: View = layout.findViewById(R.id.layout_ticker)
    private val tickerText: TextView = layout.findViewById(R.id.text_ticker)

    private val activeColor = layout.resources.getColor(R.color.text_color)
    private val inactiveColor = layout.resources.getColor(R.color.text_color_inactive)

    init {
        tickerLayout.setOnClickListener {
            tickerClickListener?.invoke()
        }
    }

    fun setTicker(ticker: String?) {
        if (ticker != null) {
            tickerText.text = ticker
            tickerText.setTextColor(activeColor)
        } else {
            tickerText.setText(R.string.stock_add_ticker_placeholder)
            tickerText.setTextColor(inactiveColor)
        }
    }

}