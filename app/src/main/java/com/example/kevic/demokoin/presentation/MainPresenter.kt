package com.example.kevic.demokoin.presentation

import com.example.kevic.demokoin.domain.usecases.GetPostsUseCase
import com.example.kevic.demokoin.domain.usecases.GetUsernameUseCase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainPresenter(private val mainView: MainView,
                    private val getUsernameUseCase: GetUsernameUseCase,
                    private val getPostsUseCase: GetPostsUseCase) {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    fun getUsername() {
        mainView.showUsername(getUsernameUseCase.getUsername())
    }

    fun getPosts() {
        scope.launch {
            val posts = getPostsUseCase.getPosts()
            mainView.showPosts(posts)
        }
    }

    fun onDestroy() {
        coroutineContext.cancel()
    }

}