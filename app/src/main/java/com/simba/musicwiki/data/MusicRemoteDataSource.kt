package com.simba.musicwiki.data

import com.simba.musicwiki.data.models.ArtistDetailsResponse
import com.simba.musicwiki.data.models.TagListResponse
import com.simba.musicwiki.data.models.album.AlbumDetailsResponse
import com.simba.musicwiki.data.models.genre.GenreDetailsResponse
import com.simba.musicwiki.data.models.tracks.TrackDetailsResponse

interface MusicRemoteDataSource {
    suspend fun getTopGenres(): TagListResponse
    suspend fun getAlbumDetails(tag: String): AlbumDetailsResponse
    suspend fun getGenreDetails(tag: String): GenreDetailsResponse
    suspend fun getArtistDetails(tag: String): ArtistDetailsResponse
    suspend fun getTrackDetails(tag: String): TrackDetailsResponse
}

class DefaultMusicRemoteDataSource(
    private val musicApiService: MusicApiService
) : MusicRemoteDataSource {

    override suspend fun getTopGenres(): TagListResponse {
        return musicApiService.getTopTags()
    }

    override suspend fun getAlbumDetails(tag: String): AlbumDetailsResponse {
        return musicApiService.getDetailsOfAlbum(tag = tag)
    }

    override suspend fun getGenreDetails(tag: String): GenreDetailsResponse {
        return musicApiService.getDetailsOfGenre(tag = tag)
    }

    override suspend fun getArtistDetails(tag: String): ArtistDetailsResponse {
        return musicApiService.getDetailsOfArtists(tag = tag)
    }


    override suspend fun getTrackDetails(tag: String): TrackDetailsResponse {
        return musicApiService.getDetailsOfTracks(tag = tag)
    }
}