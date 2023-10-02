package com.example.joke

import retrofit.Call
import retrofit.http.GET
import retrofit.http.Query

// This interface defines an API
// service for getting random jokes.
interface ApiService {
    // This annotation specifies that the HTTP method
    // is GET and the endpoint URL is "jokes/random".
    @GET("test-chat")
    // This method returns a Call object with a generic
    // type of DataModel, which represents
    // the data model for the response.
    fun getjokes(@Query("query") query: String): Call<DataModel>
}