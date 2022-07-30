package com.wajahat.aidlserver.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
fun <A> resultLiveData(networkCall: suspend () -> Result<A>): LiveData<Result<A>> =
    liveData(Dispatchers.IO) {
        emit(Result.loading())
        val response = networkCall.invoke()
        if (response.status == Result.Status.SUCCESS) {
            emit(Result.success(response.data!!))
        } else if (response.status == Result.Status.ERROR) {
            emit(Result.error(response.message!!))
        }
    }