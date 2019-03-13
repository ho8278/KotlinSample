package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

class GitRepository(
    @SerializedName("name")
    val name:String="",

    @SerializedName("full_name")
    val fullName:String="",

    @SerializedName("html_url")
    val url:String="",

    @SerializedName("private")
    val private:Boolean=false
)