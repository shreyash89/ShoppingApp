/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 1:10 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 1/3/20 10:47 AM
 *
 */


package assignment.android.com.shoppingapp.module

import assignment.android.com.shoppingapp.data.api.ApiService
import assignment.android.com.shoppingapp.data.repo.ShoppingRepo
import assignment.android.com.shoppingapp.data.utils.BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val repoModule = module {

    single {
        ShoppingRepo(get())
    }
}

val apiModule = module {

    fun provideUserApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    single {
        provideUserApi(get())
    }
}

val retrofitModule = module {

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    single {
        provideHttpClient()
    }

    single {
        provideRetrofit(get())
    }
}