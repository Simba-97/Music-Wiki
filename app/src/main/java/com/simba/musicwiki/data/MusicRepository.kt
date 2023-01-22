package com.simba.musicwiki.data

import com.simba.musicwiki.data.models.ArtistDetailsResponse
import com.simba.musicwiki.data.models.TagListResponse
import com.simba.musicwiki.data.models.album.AlbumDetailsResponse
import com.simba.musicwiki.data.models.genre.GenreDetailsResponse
import com.simba.musicwiki.data.models.tracks.TrackDetailsResponse
import javax.inject.Inject

interface MusicRepository {
    suspend fun getTopGenres(): TagListResponse
    suspend fun getAlbumDetails(tag: String): AlbumDetailsResponse
    suspend fun getGenreDetails(tag: String): GenreDetailsResponse
    suspend fun getArtistDetails(tag: String): ArtistDetailsResponse
    suspend fun getTrackDetails(tag: String): TrackDetailsResponse
}

class DefaultMusicRepository @Inject constructor(
    private val musicRemoteDataSource: MusicRemoteDataSource
) : MusicRepository {

    override suspend fun getTopGenres(): TagListResponse {
        return musicRemoteDataSource.getTopGenres()
    }

    override suspend fun getAlbumDetails(tag: String): AlbumDetailsResponse {
        return musicRemoteDataSource.getAlbumDetails(tag = tag)
    }

    override suspend fun getGenreDetails(tag: String): GenreDetailsResponse {
        return musicRemoteDataSource.getGenreDetails(tag = tag)
    }

    override suspend fun getArtistDetails(tag: String): ArtistDetailsResponse {
        return musicRemoteDataSource.getArtistDetails(tag = tag)
    }

    override suspend fun getTrackDetails(tag: String): TrackDetailsResponse {
        return musicRemoteDataSource.getTrackDetails(tag = tag)
    }
}