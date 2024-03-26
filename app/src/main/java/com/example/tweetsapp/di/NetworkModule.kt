package com.example.tweetsapp.di

import com.example.tweetsapp.api.TweetsApi
import com.google.gson.Gson
import com.google.gson.internal.GsonBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun providesTweetApi(retrofit: Retrofit) : TweetsApi{
        return  retrofit.create(TweetsApi::class.java)
    }
}