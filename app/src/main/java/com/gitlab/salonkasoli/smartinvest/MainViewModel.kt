package com.gitlab.salonkasoli.smartinvest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import yahoofinance.Stock
import yahoofinance.YahooFinance

class MainViewModel : ViewModel() {

    var successListener: (() -> Unit)? = null

    fun loadTicker() {
        viewModelScope.launch {
            loadTickerAsync()
            withContext(Dispatchers.Main) {
                successListener?.invoke()
            }
        }
    }

    suspend fun loadTickerAsync() {
        withContext(Dispatchers.IO) {
            val stock: Stock = YahooFinance.get("KO")
            val price = stock.quote.price
            Log.wtf("lol", "price is = $price")
        }
    }
}