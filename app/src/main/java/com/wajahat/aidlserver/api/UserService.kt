package com.wajahat.aidlserver.api

import com.wajahat.aidlserver.data.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
interface UserService {

    @FormUrlEncoded
    @POST("sign_in.php")
    suspend fun login(
        @Field(email) name: String,
        @Field(password) pwd: String
    ): Response<LoginResponse>
}