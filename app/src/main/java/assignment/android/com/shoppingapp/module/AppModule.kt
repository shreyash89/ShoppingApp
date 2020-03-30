/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 1:09 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 1/3/20 10:47 AM
 *
 */


package assignment.android.com.shoppingapp.module

import assignment.android.com.shoppingapp.data.repo.ShoppingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        ShoppingViewModel(get())
    }

}