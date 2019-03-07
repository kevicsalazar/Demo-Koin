package com.example.kevic.demokoin.domain.repository

import com.example.kevic.demokoin.data.entities.Post

interface PostsRepository {

    suspend fun getPosts(): List<Post>

}