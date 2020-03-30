/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 10:20 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 10:14 PM
 *
 */

package assignment.android.com.shoppingapp.ui.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import assignment.android.com.shoppingapp.R
import assignment.android.com.shoppingapp.data.model.Conversion
import assignment.android.com.shoppingapp.data.repo.ShoppingViewModel
import assignment.android.com.shoppingapp.data.utils.AppUtils
import assignment.android.com.shoppingapp.data.utils.NetworkState
import assignment.android.com.shoppingapp.ui.adapter.ShoppingAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


class ShoppingActivity : AppCompatActivity() {

    private val viewModel by viewModel<ShoppingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getProductInfo()

        initListener()

        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)


        toggle.setOnToggleSwitchChangeListener { position, isChecked ->

            val currency =  when(position){
              0 -> "INR"
              1 -> "AED"
              2 -> "SAR"
              else -> {
                  "NA"
              }
          }
            ((recycler_view.adapter) as ShoppingAdapter).selectCurrency(currency)
        }
    }



    private fun initListener() {

        viewModel.result.observe(this, Observer {


            getCurrencies(it.conversion)

            recycler_view.adapter = ShoppingAdapter(this, it.products, "INR")
            tv_title.text = it.title

        })


        viewModel.networkState.observe(this, Observer {
            progress_bar.visibility = if (it == NetworkState.LOADING) View.VISIBLE else View.GONE
            txt_error.visibility = if (it == NetworkState.ERROR) {
                View.VISIBLE
            } else {
                View.GONE
            }

        })

    }

    private fun getCurrencies(conversion: List<Conversion>) {

        AppUtils.setCurrencies(conversion)

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }

}
