package com.example.myapplication.repository.remote

import android.util.Log
import com.example.myapplication.model.GitRepository
import com.example.myapplication.repository.GithubClient
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GithubAPIImpl : GithubAPI{
    override fun getRepos(user:String) : Single<List<GitRepository>>{
        Log.e("HHH",user)
        return GithubClient.create(GithubAPI::class.java).getRepos(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}