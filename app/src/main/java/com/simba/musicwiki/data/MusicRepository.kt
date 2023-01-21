package com.simba.musicwiki.data

import com.simba.musicwiki.data.models.TagListResponse
import javax.inject.Inject

interface MusicRepository {
    suspend fun getTopGenres(): TagListResponse
}

class DefaultMusicRepository @Inject constructor(
    private val musicRemoteDataSource: MusicRemoteDataSource
) : MusicRepository {

    override suspend fun getTopGenres(): TagListResponse {
        return musicRemoteDataSource.getTogGenres()
    }

}