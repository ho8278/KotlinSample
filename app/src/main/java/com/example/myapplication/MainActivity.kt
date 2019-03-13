package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.repository.remote.GithubAPIImpl
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var text:TextInputEditText = findViewById(R.id.tiet_id)
        var button:Button = findViewById(R.id.button_login)
        button.setOnClickListener{
            GithubAPIImpl().getRepos(text.text.toString())
                .subscribe({ list-> Log.d("HHH",list.toString()) }
                ,{error->Log.e("Error",error.toString())})
        }
    }

    fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}