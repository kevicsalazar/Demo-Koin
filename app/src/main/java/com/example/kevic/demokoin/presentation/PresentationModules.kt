package com.example.kevic.demokoin.presentation

import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val presenterModule: Module = module {
    factory { params -> MainPresenter(mainView = params[0], getUsernameUseCase = get()) }
}