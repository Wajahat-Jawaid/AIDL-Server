package com.wajahat.socialmobiletestserver.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.wajahat.socialmobiletestserver.IPCLoginCredentials
import com.wajahat.socialmobiletestserver.data.LoginCredentials
import com.wajahat.socialmobiletestserver.data.LoginCredentialsHolder

class IPCServerService : Service() {

    // AIDL IPC - Binder object to pass to the client
    private val aidlBinder = object : IPCLoginCredentials.Stub() {

        override fun setLoginCredentials(credentials: LoginCredentials?) {
            LoginCredentialsHolder.credentials = credentials
        }
    }

    // Pass the binder object to clients so they can communicate with this service
    override fun onBind(intent: Intent?): IBinder {
        return aidlBinder
    }
}