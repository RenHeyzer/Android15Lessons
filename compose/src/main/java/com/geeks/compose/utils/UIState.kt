package com.geeks.compose.utils

sealed class UIState<out T> {

    data object Loading : UIState<Nothing>()

    data class Error(val throwable: Throwable, val message: String? = null) : UIState<Nothing>()

    data class Success<T>(val data: T? = null) : UIState<T>()
}