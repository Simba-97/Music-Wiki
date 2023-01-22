package com.simba.musicwiki.domain

import com.simba.musicwiki.data.MusicRepository
import com.simba.musicwiki.data.models.album_details.AlbumResponse
import com.simba.musicwiki.di.IoDispatcher
import com.simba.musicwiki.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetAlbumUseCase @Inject constructor(
    private val repository: MusicRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<AlbumParams, AlbumResponse>(ioDispatcher) {
    override suspend fun execute(parameter: AlbumParams): AlbumResponse {
        return repository.getAlbum(album = parameter.album, artist = parameter.artist)
    }
}

data class AlbumParams(
    val album: String,
    val artist: String
)