package com.simba.musicwiki.domain

import com.simba.musicwiki.data.MusicRepository
import com.simba.musicwiki.data.models.TagListResponse
import com.simba.musicwiki.di.IoDispatcher
import com.simba.musicwiki.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetTopGenresUseCase @Inject constructor(
    private val repository: MusicRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<Unit, TagListResponse>(ioDispatcher) {
    override suspend fun execute(parameter: Unit): TagListResponse {
        return repository.getTopGenres()
    }
}