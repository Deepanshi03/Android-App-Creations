package com.example.chachachaudharyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chachachaudharyapp.databinding.ActivityHomeBinding
import com.example.chachachaudharyapp.databinding.ActivityMainBinding

class Home : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBar()
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.toolbarHomeActivity)
        val actionBar=supportActionBar
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title="Home"
        }
        binding.toolbarHomeActivity.setNavigationOnClickListener { onBackPressed() }
    }
}