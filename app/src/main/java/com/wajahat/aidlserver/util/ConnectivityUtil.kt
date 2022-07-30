package com.wajahat.aidlserver.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
object ConnectivityUtil {

    fun isConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}