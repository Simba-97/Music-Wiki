package com.simba.musicwiki.domain

import com.simba.musicwiki.data.MusicRepository
import com.simba.musicwiki.data.models.artist_top_tracks.ArtistTopTracksResponse
import com.simba.musicwiki.di.IoDispatcher
import com.simba.musicwiki.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetArtistTopTracksUseCase @Inject constructor(
    private val musicRepository: MusicRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<String, ArtistTopTracksResponse>(ioDispatcher) {

    override suspend fun execute(parameter: String): ArtistTopTracksResponse {
        return musicRepository.getArtistTopTracks(parameter)
    }

}