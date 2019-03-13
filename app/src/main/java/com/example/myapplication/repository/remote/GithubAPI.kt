package com.example.myapplication.repository.remote

import com.example.myapplication.model.GitRepository
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI{
    @GET("{user}/repos?Authorization=token 5295a4248cca470e804e6027f492a018ac54c50a")
    fun getRepos(@Path("user") user:String): Single<List<GitRepository>>
}