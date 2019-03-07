package com.example.kevic.demokoin.data.repository

import com.example.kevic.demokoin.data.datasource.PostsRemoteDataSource
import com.example.kevic.demokoin.data.entities.Post
import com.example.kevic.demokoin.domain.repository.PostsRepository

class PostsDataRepository(private val postsRemoteDataSource: PostsRemoteDataSource) : PostsRepository {

    override suspend fun getPosts(): List<Post> {
        return postsRemoteDataSource.getPosts()
    }
}