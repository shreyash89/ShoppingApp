/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 12:53 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 30/3/20 12:53 PM
 *
 */

package assignment.android.com.shoppingapp.data.utils

import android.util.Log
import assignment.android.com.shoppingapp.data.model.Conversion

const val BASE_URL = "http://a2b7cf8676394fda75de-6e0550a16cd96615f7274fd70fa77109.r93.cf3.rackcdn.com/"

class AppUtils {


    companion object{
        lateinit var currencySet : HashSet<String>
        lateinit var conversionList : List<Conversion>


        fun setCurrencies(conversions : List<Conversion>){

            conversionList = conversions
            currencySet = HashSet()

            for(conversion in conversions){

                if(!currencySet.contains(conversion.from)){
                    currencySet.add(conversion.from)
                }else{
                    Log.e("AppUtils", "Already present in set")
                }
                if(!currencySet.contains(conversion.to)){
                    currencySet.add(conversion.to)
                }else{
                    Log.e("AppUtils", "Already present in set")
                }

            }


            Log.e("AppUtils", "Size of currency set  ${currencySet.size}")

        }


        fun getRate(from : String, to :String) : Double {

            for(conversion in conversionList){
                if(conversion.from == from && conversion.to == to){

                    return conversion.rate.toDouble()

                }
            }
            return (-1).toDouble()
        }

    }
}