package com.example.kevic.demokoin.utils

import android.app.Activity
import android.support.v4.app.Fragment
import android.util.Log
import org.koin.android.ext.android.inject
import org.koin.core.parameter.ParameterList
import retrofit2.Response
import java.io.IOException

inline fun <reified T : Any> Activity.injectActivity(): Lazy<T> =
    inject(parameters = { ParameterList(this) })

inline fun <reified T : Any> Fragment.injectFragment(): Lazy<T> =
    inject(parameters = { ParameterList(this) })


sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {

    val result : Result<T> = safeApiResult(call,errorMessage)
    var data : T? = null

    when(result) {
        is Result.Success ->
            data = result.data
        is Result.Error -> {
            Log.d("1.DataRepository", "$errorMessage & Exception - ${result.exception}")
        }
    }

    return data
}

private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>, errorMessage: String) : Result<T>{
    val response = call.invoke()
    if(response.isSuccessful) return Result.Success(response.body()!!)

    return Result.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
}