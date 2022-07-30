package com.wajahat.aidlserver.di

import com.wajahat.aidlserver.ui.MainActivity
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