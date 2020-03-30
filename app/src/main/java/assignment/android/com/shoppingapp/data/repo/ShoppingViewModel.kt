/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 1:07 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 1:07 PM
 *
 */

package assignment.android.com.shoppingapp.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import assignment.android.com.shoppingapp.data.model.Shopping
import assignment.android.com.shoppingapp.data.utils.NetworkState

class ShoppingViewModel(private val shoppingRepo: ShoppingRepo) : ViewModel() {


    lateinit var result: LiveData<Shopping>

    val networkState: LiveData<NetworkState> by lazy {
        shoppingRepo.getProductNetworkState()
    }

    fun getProductInfo(): LiveData<Shopping> {
        result = shoppingRepo.getProductsInfo()
        return result
    }

    fun cancelJobs() {
        shoppingRepo.cancelJobs()
    }
}