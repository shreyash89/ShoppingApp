/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 12:47 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 12:47 PM
 *
 */

package assignment.android.com.shoppingapp.data.model


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("url")
    val url: String
)