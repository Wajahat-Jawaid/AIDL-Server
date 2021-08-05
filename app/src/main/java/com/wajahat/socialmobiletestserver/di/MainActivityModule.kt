package com.wajahat.socialmobiletestserver.di

import com.wajahat.socialmobiletestserver.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}