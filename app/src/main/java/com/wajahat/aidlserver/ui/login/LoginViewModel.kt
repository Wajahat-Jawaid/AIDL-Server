package com.wajahat.aidlserver.ui.login

import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wajahat.aidlclient.IPCProfile
import com.wajahat.aidlserver.R
import com.wajahat.aidlserver.api.UserRepository
import com.wajahat.aidlserver.data.LoginCredentialsHolder
import com.wajahat.aidlserver.data.Result
import com.wajahat.aidlserver.data.response.LoginResponse
import javax.inject.Inject

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
class LoginViewModel @Inject constructor(
    private val repository: UserRepository,
    private val app: Application
) : AndroidViewModel(app), ServiceConnection {

    private var iRemoteService: IPCProfile? = null
    val response = MutableLiveData<LoginResponse>()

    fun login(username: String, password: String): LiveData<Result<LoginResponse>> {
        return repository.login(username, password)
    }

    fun connectToRemoteService() {
        val intent = Intent("profileResponse")
        val pack = IPCProfile::class.java.`package`
        pack?.let {
            intent.setPackage(pack.name)
            app.applicationContext?.bindService(
                intent, this, Context.BIND_AUTO_CREATE
            )
        }
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        // Gets an instance of the AIDL interface named IPCProfile,
        // which we can use to call on the service
        iRemoteService = IPCProfile.Stub.asInterface(service)
        iRemoteService?.setLoginResponse(response.value!!.data)
        LoginCredentialsHolder.credentials = null
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        Toast.makeText(app, R.string.server_disconnected, Toast.LENGTH_LONG).show()
        iRemoteService = null
    }
}