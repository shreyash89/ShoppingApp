/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 12:47 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 12:47 PM
 *
 */

package assignment.android.com.shoppingapp.data.model


import com.google.gson.annotations.SerializedName

data class Conversion(
    @SerializedName("from")
    val from: String,
    @SerializedName("rate")
    val rate: String,
    @SerializedName("to")
    val to: String
)