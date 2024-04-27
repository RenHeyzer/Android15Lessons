package com.geeks.compose.utils.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geeks.compose.utils.Either
import com.geeks.compose.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

typealias UIStateLiveData<T> = LiveData<UIState<T>>

abstract class BaseViewModel : ViewModel() {

    protected open fun <T> uiStateLiveData() = MutableLiveData<UIState<T>>(UIState.Loading)

    protected open fun <T> Flow<Either<Throwable, T>>.collectFlowAsState(
        state: MutableLiveData<UIState<T>>,
    ) {
        viewModelScope.launch {
            this@collectFlowAsState.collect {
                when (it) {
                    is Either.Left -> {
                        it.left?.let { t ->
                            val message = t.message ?: "Unknown error!"
                            state.value = UIState.Error(t, message)
                        }
                    }

                    is Either.Right -> {
                        it.right?.let { data ->
                            state.value = UIState.Success(data)
                        }
                    }
                }
            }
        }
    }
}