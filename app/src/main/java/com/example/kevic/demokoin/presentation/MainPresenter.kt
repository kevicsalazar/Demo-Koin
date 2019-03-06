package com.example.kevic.demokoin.presentation

import com.example.kevic.demokoin.domain.usecases.GetUsernameUseCase

class MainPresenter(private val mainView: MainView,
                    private val getUsernameUseCase: GetUsernameUseCase) {

    fun getUsername() {
        mainView.showUsername(getUsernameUseCase.getUsername())
    }

}