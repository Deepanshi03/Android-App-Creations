package com.example.chachachaudharyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IntroActivity : AppCompatActivity() {

    lateinit var get_started_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        get_started_btn=findViewById(R.id.get_started_btn)
        get_started_btn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}