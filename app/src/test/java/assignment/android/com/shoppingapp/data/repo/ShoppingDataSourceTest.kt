/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 10:24 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 10:24 PM
 *
 */

package assignment.android.com.shoppingapp.data.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import assignment.android.com.shoppingapp.data.api.ApiService
import assignment.android.com.shoppingapp.data.model.Product
import assignment.android.com.shoppingapp.data.model.Shopping
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate

@RunWith(MockitoJUnitRunner::class)
@PowerMockRunnerDelegate(MockitoJUnitRunner::class)
class ShoppingDataSourceTest {


    private lateinit var shoppingDataSource: ShoppingDataSource

    @Mock
    lateinit var apiService: ApiService


    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        shoppingDataSource = ShoppingDataSource(apiService)
    }

    @Test
    fun getProductsInfo_success() {

        val results = listOf<Product>()
        CoroutineScope(Dispatchers.IO).launch {
            val productInfo: Shopping = apiService.getProductsInfo()
            Mockito.`when`(productInfo.products).thenReturn(results)

            assertNotNull(shoppingDataSource.getProductsInfo().value)

            shoppingDataSource.getProductsInfo()


            assertEquals(
                shoppingDataSource.getProductsInfo().value?.products?.get(0)?.name, results.get(0).name
            )

        }

    }

    @Test
    fun getProductsInfo_fail() {

        CoroutineScope(Dispatchers.IO).launch {
            val productInfo: Shopping = apiService.getProductsInfo()
            Mockito.`when`(productInfo.products).thenReturn(null)

            assertNotNull(shoppingDataSource.getProductsInfo().value)

            shoppingDataSource.getProductsInfo()

            assertEquals(
                shoppingDataSource.getProductsInfo().value?.products?.get(0)?.name, null
            )

        }
    }
}