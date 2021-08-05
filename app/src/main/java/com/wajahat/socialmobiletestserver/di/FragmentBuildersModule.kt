package com.wajahat.socialmobiletestserver.di

import com.wajahat.socialmobiletestserver.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment
}
