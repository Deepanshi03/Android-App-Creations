package com.example.chachachaudharyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.chachachaudharyapp.databinding.ActivityChatBinding
import com.example.chachachaudharyapp.databinding.ActivityHomeBinding
import com.example.joke.ApiCall

class Chat : AppCompatActivity() {

    lateinit var binding: ActivityChatBinding
    var query: String = "hi"
    private lateinit var submitButton: Button
    private lateinit var outputTextView: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBar()

        submitButton = findViewById(R.id.submitButton)

        // Find the text view by its ID and
        // assign it to a variable.
        outputTextView = findViewById(R.id.outputTextView)

        // Find the progress bar and assign
        // it to the varriable.
        progressBar = findViewById(R.id.idLoadingPB)

        // Set an OnClickListener on the button view.
        submitButton.setOnClickListener {
            // show the progress bar
            val a = binding.inputEditText.text.toString().replace("","%20")
            query=a
            progressBar.visibility = View.VISIBLE

            // Call the getjokes() method of the ApiCall class,
            // passing a callback function as a parameter.
            ApiCall().getjokes(this,query) { jokes ->
                // Set the text of the text view to the
                // joke value returned by the API response.
                outputTextView.text = jokes.response
                // hide the progress bar
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.toolbarChatActivity)
        val actionBar=supportActionBar
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title="Chat"
        }
        binding.toolbarChatActivity.setNavigationOnClickListener { onBackPressed() }
    }


}