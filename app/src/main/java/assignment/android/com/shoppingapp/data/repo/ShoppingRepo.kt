/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 1:00 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 1:00 PM
 *
 */

package assignment.android.com.shoppingapp.data.repo

import androidx.lifecycle.LiveData
import assignment.android.com.shoppingapp.data.api.ApiService
import assignment.android.com.shoppingapp.data.model.Shopping
import assignment.android.com.shoppingapp.data.utils.NetworkState

class ShoppingRepo(private val apiService: ApiService) {

    lateinit var shoppingDataSource: ShoppingDataSource

    fun getProductsInfo(): LiveData<Shopping> {

        shoppingDataSource = ShoppingDataSource(apiService)
        return shoppingDataSource.getProductsInfo()

    }

    fun getProductNetworkState(): LiveData<NetworkState> {
        return shoppingDataSource.networkState
    }

    fun cancelJobs() {
        shoppingDataSource.cancelJobs()
    }

}