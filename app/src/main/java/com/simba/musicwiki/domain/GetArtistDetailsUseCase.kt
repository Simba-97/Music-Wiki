package com.simba.musicwiki.domain

import com.simba.musicwiki.data.MusicRepository
import com.simba.musicwiki.data.models.ArtistDetailsResponse
import com.simba.musicwiki.di.IoDispatcher
import com.simba.musicwiki.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetArtistDetailsUseCase @Inject constructor(
    private val musicRepository: MusicRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<String, ArtistDetailsResponse>(ioDispatcher) {
    override suspend fun execute(parameter: String): ArtistDetailsResponse {
        return musicRepository.getArtistDetails(parameter)
    }
}