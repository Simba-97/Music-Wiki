package com.simba.musicwiki.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<in P, out R>(val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(p: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                val result = execute(p)
                Result.Success(result)
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    abstract suspend fun execute(parameter: P): R
}