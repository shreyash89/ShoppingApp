/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 3:50 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 1/3/20 10:47 AM
 *
 */

package assignment.android.com.shoppingapp.data.utils

import android.widget.ImageView
import android.widget.RatingBar
import androidx.databinding.BindingAdapter
import assignment.android.com.shoppingapp.R
import com.bumptech.glide.Glide

class ViewBindingAdapter {

    companion object {

        @BindingAdapter("imageUrl")
        @JvmStatic
        fun setImage(view: ImageView, id: String) {

            var context = view.context

            Glide.with(context)
                .load(id)
                .placeholder(R.drawable.ic_launcher_background) //placeholder
                .error(R.drawable.ic_launcher_background) //error
                .into(view)
        }


    }

}