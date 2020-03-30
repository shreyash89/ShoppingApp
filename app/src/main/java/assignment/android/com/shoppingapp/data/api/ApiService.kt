/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 12:50 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 12:50 PM
 *
 */

package assignment.android.com.shoppingapp.data.api

import assignment.android.com.shoppingapp.data.model.Shopping
import retrofit2.http.GET

interface ApiService {

    @GET("common/json/assignment.json")
    suspend fun getProductsInfo() : Shopping
}