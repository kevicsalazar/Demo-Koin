package com.example.kevic.demokoin.data.network

import com.example.kevic.demokoin.data.entities.Post
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PostsApi {

    @GET("typicode/demo/posts")
    fun getPosts(): Deferred<Response<List<Post>>>

}