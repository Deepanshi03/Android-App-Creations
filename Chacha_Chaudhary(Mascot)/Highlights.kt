package com.example.chachachaudharyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import java.util.Timer
import kotlin.concurrent.timerTask
import android.os.Handler
import com.example.chachachaudharyapp.adapters.Highlights_adapter
import com.example.chachachaudharyapp.databinding.ActivityHighlightsBinding

class HighlightsActivity : AppCompatActivity() {

    lateinit var binding: ActivityHighlightsBinding

    private lateinit var viewPager: ViewPager
    private val images = listOf(
        R.drawable.g1,
        R.drawable.g2,
        R.drawable.g3,
        R.drawable.g4,
        R.drawable.g5,
        R.drawable.g6
    )
    private var currentPage = 0
    private var timer: Timer? = null
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHighlightsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBar()

        viewPager = findViewById(R.id.idViewPager)
        val adapter = Highlights_adapter(this, images)
        viewPager.adapter = adapter
        val update = Runnable {
            if (currentPage == images.size) {
                currentPage = 0
            }
            viewPager.setCurrentItem(currentPage++, true)
        }
        timer = Timer()
        timer?.scheduleAtFixedRate(timerTask { handler.post(update) }, 2000, 2000)
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.toolbarHighlightsActivity)
        val actionBar=supportActionBar
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title="Highlights"
        }
        binding.toolbarHighlightsActivity.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}