package com.example.kevic.demokoin.domain

import com.example.kevic.demokoin.domain.usecases.GetPostsUseCase
import com.example.kevic.demokoin.domain.usecases.GetUsernameUseCase
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val useCaseModule: Module = module {
    factory { GetUsernameUseCase(userRepository = get()) }
    factory { GetPostsUseCase(postsRepository = get()) }
}