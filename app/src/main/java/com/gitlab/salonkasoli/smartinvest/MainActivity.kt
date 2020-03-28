package com.gitlab.salonkasoli.smartinvest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

/**
 * Activitiy, where you can find your portfolios.
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //viewModel.loadTicker()

        PortfolioController(
            PortfoliosWidget(
                findViewById(R.id.list),
                findViewById(R.id.fab)
            ),
            this
        )

    }
}
