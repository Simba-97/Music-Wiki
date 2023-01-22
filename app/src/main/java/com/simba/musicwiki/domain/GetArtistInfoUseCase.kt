package com.simba.musicwiki.domain

import com.simba.musicwiki.data.MusicRepository
import com.simba.musicwiki.data.models.artist_info.ArtistInfoResponse
import com.simba.musicwiki.di.IoDispatcher
import com.simba.musicwiki.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetArtistInfoUseCase @Inject constructor(
    private val musicRepository: MusicRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<String, ArtistInfoResponse>(ioDispatcher) {
    override suspend fun execute(parameter: String): ArtistInfoResponse {
        return musicRepository.getArtistInfo(parameter)
    }
}