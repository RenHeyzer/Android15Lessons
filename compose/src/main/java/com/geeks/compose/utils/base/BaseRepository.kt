package com.geeks.compose.utils.base

import com.geeks.compose.utils.AppDispatchers
import com.geeks.compose.utils.Either
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository(private val appDispatchers: AppDispatchers) {

    protected fun <T> doRequest(
        request: suspend () -> T,
    ) = flow<Either<Throwable, T>> {
        emit(
            Either.Right(request())
        )
    }.flowOn(appDispatchers.io).catch {
        emit(Either.Left(it))
    }
}