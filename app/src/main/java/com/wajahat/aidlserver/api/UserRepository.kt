package com.wajahat.aidlserver.api

import com.wajahat.aidlserver.data.resultLiveData
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