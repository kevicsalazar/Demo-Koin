package com.example.kevic.demokoin

import com.example.kevic.demokoin.data.dataSourceModule
import com.example.kevic.demokoin.data.repositoryModule
import com.example.kevic.demokoin.domain.useCaseModule
import com.example.kevic.demokoin.presentation.presenterModule
import org.koin.standalone.StandAloneContext.loadKoinModules

object AppModule {

    fun inject() = loadFeature

    private val loadFeature by lazy {
        loadKoinModules(
            presenterModule,
            useCaseModule,
            repositoryModule,
            dataSourceModule
        )
    }

}