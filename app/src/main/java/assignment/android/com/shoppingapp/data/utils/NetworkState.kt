/*
 * *
 *  * Created by Shreyash Mohta on 30/3/20 12:54 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 1/3/20 10:47 AM
 *
 */
package assignment.android.com.shoppingapp.data.utils

enum class Status {
    RUNNING, SUCCESS, FAILED

}

class NetworkState(val status: Status, val message: String) {

    companion object {

        val LOADED: NetworkState = NetworkState(Status.SUCCESS, "Success")
        val LOADING: NetworkState = NetworkState(Status.RUNNING, "Running")
        val ERROR: NetworkState = NetworkState(Status.FAILED, "Something went wrong")
        val ENDOFLIST: NetworkState = NetworkState(Status.FAILED, "End game")

    }


}