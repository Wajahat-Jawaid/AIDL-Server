package com.wajahat.socialmobiletestserver.di

import com.wajahat.socialmobiletestserver.BuildConfig
import com.wajahat.socialmobiletestserver.api.UserRepository
import com.wajahat.socialmobiletestserver.api.UserService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Wajahat Jawaid(wajahatjawaid@gmail.com)
 */
@Module(includes = [ViewModelModule::class, CoreDataModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideUserService(
        @UserAPI okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = provideService(okhttpClient, converterFactory, UserService::class.java)

    @Singleton
    @Provides
    fun provideUserRepository(service: UserService) = UserRepository(service)

    @UserAPI
    @Provides
    fun providePrivateOkHttpClient(client: OkHttpClient): OkHttpClient {
        // We can add interceptors here
        return client.newBuilder().build()
    }

    private fun createRetrofit(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    private fun <T> provideService(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory, clazz: Class<T>
    ): T {
        return createRetrofit(okhttpClient, converterFactory).create(clazz)
    }
}