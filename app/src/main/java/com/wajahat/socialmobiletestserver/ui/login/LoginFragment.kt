package com.wajahat.socialmobiletestserver.ui.login

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import com.wajahat.socialmobiletestserver.R
import com.wajahat.socialmobiletestserver.core.BaseFragment
import com.wajahat.socialmobiletestserver.data.LoginCredentialsHolder
import com.wajahat.socialmobiletestserver.data.Result
import com.wajahat.socialmobiletestserver.databinding.FragmentLoginBinding
import com.wajahat.socialmobiletestserver.di.Injectable
import com.wajahat.socialmobiletestserver.di.injectViewModel

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
class LoginFragment : BaseFragment<FragmentLoginBinding>(), Injectable {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = injectBinding(view)
        viewModel = injectViewModel(viewModelFactory)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        val credentials = LoginCredentialsHolder.credentials
        if (credentials != null) {
            binding.credentials = credentials
            binding.textLoginAttemptMsg.text = getString(R.string.login_attempt_processing)
            binding.progressBar.visibility = View.VISIBLE
            binding.textCredentials.visibility = View.VISIBLE
            loginAction(credentials.email, credentials.password)
        } else {
            updateUI(R.string.login_attempt_ask)
        }
    }

    private fun loginAction(username: String, password: String) {
        viewModel.login(username, password).observe(viewLifecycleOwner) {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    if (it.data != null) {
                        viewModel.response.value = it.data
                        viewModel.connectToRemoteService()
                        updateUI(R.string.login_success)
                    }
                }
                Result.Status.LOADING -> {
                }
                Result.Status.ERROR -> {
                }
            }
        }
    }

    private fun updateUI(@StringRes msg: Int) {
        binding.textLoginAttemptMsg.text = getString(msg)
        binding.progressBar.visibility = View.GONE
        binding.textCredentials.visibility = View.GONE
    }

    override fun getViewId() = R.layout.fragment_login
    override fun injectBinding(view: View) = DataBindingUtil.bind<FragmentLoginBinding>(view)!!
}