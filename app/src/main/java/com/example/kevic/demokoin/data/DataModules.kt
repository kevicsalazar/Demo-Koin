package com.example.kevic.demokoin.data

import com.example.kevic.demokoin.data.datasource.UserDataSource
import com.example.kevic.demokoin.data.repository.UserDataRepository
import com.example.kevic.demokoin.domain.repository.UserRepository
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val repositoryModule: Module = module {
    single { UserDataRepository(userDataSource = get()) as UserRepository }
}

val dataSourceModule: Module = module {
    single { UserDataSource()  }
}

