/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 12:47 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 12:47 PM
 *
 */

package assignment.android.com.shoppingapp.data.model


import com.google.gson.annotations.SerializedName

data class Shopping(
    @SerializedName("conversion")
    val conversion: List<Conversion>,
    @SerializedName("products")
    val products: List<Product>,
    @SerializedName("title")
    val title: String
)