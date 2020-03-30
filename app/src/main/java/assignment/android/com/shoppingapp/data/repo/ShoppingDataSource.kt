/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 12:55 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 12:55 PM
 *
 */

package assignment.android.com.shoppingapp.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import assignment.android.com.shoppingapp.data.api.ApiService
import assignment.android.com.shoppingapp.data.model.Shopping
import assignment.android.com.shoppingapp.data.utils.NetworkState
import kotlinx.coroutines.*

class ShoppingDataSource(private val apiService: ApiService) {

    private val TAG = "ProductDataSource"

    var job: CompletableJob? = null

    private val _networkState = MutableLiveData<NetworkState>()

    val networkState: LiveData<NetworkState>
        get() = _networkState

    /**
     * This method will give you the list of products
     */
    fun getProductsInfo(): LiveData<Shopping> {

        _networkState.postValue(NetworkState.LOADING)
        job = Job()
        return object : LiveData<Shopping>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(Dispatchers.IO + theJob).launch {
                        try {
                            val products: Shopping = apiService.getProductsInfo()
                            withContext(Dispatchers.Main) {
                                value = products
                                Log.e(TAG, "Result : $products")
                                Log.e(TAG, "Conversion : ${products.conversion}")
                                _networkState.postValue(NetworkState.LOADED)
                                theJob.complete()
                            }

                        } catch (throwable: Throwable) {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e(TAG, "Error -> ${throwable.message}")
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs() {
        job?.cancel()
    }

}