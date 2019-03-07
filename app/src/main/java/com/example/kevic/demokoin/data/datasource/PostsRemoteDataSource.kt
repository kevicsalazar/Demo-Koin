package com.example.kevic.demokoin.data.datasource

import com.example.kevic.demokoin.data.entities.Post
import com.example.kevic.demokoin.data.network.PostsApi
import com.example.kevic.demokoin.utils.safeApiCall

class PostsRemoteDataSource(private val postsApi: PostsApi) {

    suspend fun getPosts(): List<Post> {
        return safeApiCall(
            call = { postsApi.getPosts().await() },
            errorMessage = "Error Fetching Popular Movies"
        ) ?: emptyList()
    }

}