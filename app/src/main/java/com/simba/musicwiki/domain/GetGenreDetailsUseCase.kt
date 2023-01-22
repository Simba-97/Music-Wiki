package com.simba.musicwiki.domain

import com.simba.musicwiki.data.MusicRepository
import com.simba.musicwiki.data.models.genre.GenreDetailsResponse
import com.simba.musicwiki.di.IoDispatcher
import com.simba.musicwiki.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetGenreDetailsUseCase @Inject constructor(
    private val musicRepository: MusicRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<String, GenreDetailsResponse>(ioDispatcher) {
    override suspend fun execute(parameter: String): GenreDetailsResponse {
        return musicRepository.getGenreDetails(parameter)
    }
}