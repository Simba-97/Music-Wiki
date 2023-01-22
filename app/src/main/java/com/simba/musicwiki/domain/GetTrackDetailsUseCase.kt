package com.simba.musicwiki.domain

import com.simba.musicwiki.data.MusicRepository
import com.simba.musicwiki.data.models.tracks.TrackDetailsResponse
import com.simba.musicwiki.di.IoDispatcher
import com.simba.musicwiki.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetTrackDetailsUseCase @Inject constructor(
    private val repository: MusicRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<String, TrackDetailsResponse>(ioDispatcher) {
    override suspend fun execute(parameter: String): TrackDetailsResponse {
        return repository.getTrackDetails(parameter)
    }
}