package com.simba.musicwiki.data

import com.simba.musicwiki.data.models.TagListResponse

interface MusicRemoteDataSource {
    suspend fun getTogGenres(): TagListResponse
}

class DefaultMusicRemoteDataSource(
    private val musicApiService: MusicApiService
) : MusicRemoteDataSource {
    override suspend fun getTogGenres(): TagListResponse {
        return musicApiService.getTopTags()
    }
}