package com.wajahat.aidlserver.di

import com.wajahat.aidlserver.ui.login.LoginFragment
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
