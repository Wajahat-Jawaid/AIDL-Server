package com.wajahat.aidlserver.data.response

import com.wajahat.aidlserver.data.Profile

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
data class LoginResponse(val status: Int, val data: Profile)