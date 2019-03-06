package com.example.kevic.demokoin.data.repository

import com.example.kevic.demokoin.data.datasource.UserDataSource
import com.example.kevic.demokoin.domain.repository.UserRepository

class UserDataRepository(private val userDataSource: UserDataSource) :
    UserRepository {

    override fun getUser(): String {
        return userDataSource.getUser()
    }

}