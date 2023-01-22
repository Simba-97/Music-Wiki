package com.simba.musicwiki.domain

import com.simba.musicwiki.data.MusicRepository
import com.simba.musicwiki.data.models.album.AlbumDetailsResponse
import com.simba.musicwiki.di.IoDispatcher
import com.simba.musicwiki.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetAlbumDetailsUseCase @Inject constructor(
    private val repository: MusicRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<String, AlbumDetailsResponse>(ioDispatcher) {
    override suspend fun execute(parameter: String): AlbumDetailsResponse {
        return repository.getAlbumDetails(parameter)
    }
}
