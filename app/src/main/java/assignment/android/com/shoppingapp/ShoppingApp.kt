/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 1:13 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 1:13 PM
 *
 */

package assignment.android.com.shoppingapp

import android.app.Application
import assignment.android.com.shoppingapp.module.apiModule
import assignment.android.com.shoppingapp.module.appModule
import assignment.android.com.shoppingapp.module.repoModule
import assignment.android.com.shoppingapp.module.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ShoppingApp :Application(){

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger()
            androidContext(this@ShoppingApp)
            modules(arrayListOf(appModule, apiModule, retrofitModule, repoModule))
        }
    }
}