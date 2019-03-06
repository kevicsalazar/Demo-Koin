package com.example.kevic.demokoin.domain.usecases

import com.example.kevic.demokoin.domain.repository.UserRepository

class GetUsernameUseCase(private val userRepository: UserRepository) {

    fun getUsername() : String {
        return userRepository.getUser()
    }

}