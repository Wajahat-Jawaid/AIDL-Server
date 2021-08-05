package com.wajahat.socialmobiletestserver.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.wajahat.socialmobiletestserver.data.Result
import com.wajahat.socialmobiletestserver.data.response.LoginResponse
import com.wajahat.socialmobiletestserver.data.resultLiveData
import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
class UserRepository @Inject constructor(private val service: UserService) : BaseRepository() {

        fun login(username: String, password: String) =
        resultLiveData { getResult { service.login(username, password) } }
//    fun login(username: String, password: String): LiveData<Result<LoginResponse>> {
//        Timber.d("Attempting Login")
//        return resultLiveData { getResult { service.login(username, password) } }
//    }
}