package com.example.kevic.demokoin.domain.usecases

import com.example.kevic.demokoin.data.entities.Post
import com.example.kevic.demokoin.domain.repository.PostsRepository

class GetPostsUseCase(private val postsRepository: PostsRepository) {

    suspend fun getPosts(): List<Post> {
        return postsRepository.getPosts()
    }

}