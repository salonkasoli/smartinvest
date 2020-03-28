package com.gitlab.salonkasoli.smartinvest.add

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gitlab.salonkasoli.smartinvest.R

class StockAddActivity : AppCompatActivity(R.layout.activity_add_stock) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        StockAddController(
            StockAddWidget(
                window.decorView
            )
        )

    }

    companion object {
        fun intent(context: Context) : Intent {
            return Intent(context, StockAddActivity::class.java)
        }
    }
}