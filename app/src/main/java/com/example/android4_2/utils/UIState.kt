package com.example.android4_2.utils

sealed class UIState<out T> {
    data object Loading: UIState<Nothing>()
    data class Error(val throwable: Throwable, val message: String? = null): UIState<Nothing>()
    data class Success<out T>(val data: T? = null): UIState<T>()
}