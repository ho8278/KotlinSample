package com.example.myapplication.repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GithubClient{
    companion object{

        fun <T> create(service:Class<T>):T{
            return retrofitBuild().create(service)
        }


        fun retrofitBuild():Retrofit{
            val httpLogging=HttpLoggingInterceptor()
            httpLogging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client:OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLogging)
                .build()
            
            return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://api.github.com/users/")
                .build()
        }
    }
}