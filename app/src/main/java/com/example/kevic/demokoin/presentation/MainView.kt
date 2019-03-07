package com.example.kevic.demokoin.presentation

import com.example.kevic.demokoin.data.entities.Post

interface MainView {

    fun showUsername(username: String)

    fun showPosts(posts: List<Post>)

}