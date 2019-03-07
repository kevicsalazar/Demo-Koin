package com.example.kevic.demokoin.data

import com.example.kevic.demokoin.data.datasource.PostsRemoteDataSource
import com.example.kevic.demokoin.data.datasource.UserDataSource
import com.example.kevic.demokoin.data.network.PostsApi
import com.example.kevic.demokoin.data.repository.PostsDataRepository
import com.example.kevic.demokoin.data.repository.UserDataRepository
import com.example.kevic.demokoin.domain.repository.PostsRepository
import com.example.kevic.demokoin.domain.repository.UserRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val repositoryModule: Module = module {
    single { UserDataRepository(userDataSource = get()) as UserRepository }
    single { PostsDataRepository(postsRemoteDataSource = get()) as PostsRepository }
}

val dataSourceModule: Module = module {
    single { UserDataSource() }
    single { PostsRemoteDataSource(postsApi = get()) }
}

val networkModule: Module = module {
    single { postsApi }
}

private const val BASE_URL = "https://my-json-server.typicode.com"

private val retrofit: Retrofit = createNetworkClient(BASE_URL)

private val postsApi: PostsApi = retrofit.create(PostsApi::class.java)

private fun createNetworkClient(baseUrl: String): Retrofit {
    return Retrofit.Builder()
        .client(createClient())
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}

private fun createClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .build()
}