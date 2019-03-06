package com.example.kevic.demokoin.utils

import android.app.Activity
import android.support.v4.app.Fragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.ParameterList

inline fun <reified T : Any> Activity.injectActivity(): Lazy<T> =
    inject(parameters = { ParameterList(this) })

inline fun <reified T : Any> Fragment.injectFragment(): Lazy<T> =
    inject(parameters = { ParameterList(this) })