package com.simba.musicwiki.data

import com.simba.musicwiki.data.models.ArtistDetailsResponse
import com.simba.musicwiki.data.models.TagListResponse
import com.simba.musicwiki.data.models.album.AlbumDetailsResponse
import com.simba.musicwiki.data.models.album_details.AlbumResponse
import com.simba.musicwiki.data.models.artist_info.ArtistInfoResponse
import com.simba.musicwiki.data.models.artist_top_albums.ArtistTopAlbumResponse
import com.simba.musicwiki.data.models.artist_top_tracks.ArtistTopTracksResponse
import com.simba.musicwiki.data.models.genre.GenreDetailsResponse
import com.simba.musicwiki.data.models.tracks.TrackDetailsResponse

interface MusicRemoteDataSource {
    suspend fun getTopGenres(): TagListResponse
    suspend fun getAlbumDetails(tag: String): AlbumDetailsResponse
    suspend fun getGenreDetails(tag: String): GenreDetailsResponse
    suspend fun getArtistDetails(tag: String): ArtistDetailsResponse
    suspend fun getTrackDetails(tag: String): TrackDetailsResponse
    suspend fun getArtistInfo(artist: String): ArtistInfoResponse
    suspend fun getAlbum(album: String, artist: String): AlbumResponse
    suspend fun getArtistTopTracks(artist: String): ArtistTopTracksResponse
    suspend fun getArtistTopAlbums(artist: String): ArtistTopAlbumResponse
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

    override suspend fun getArtistInfo(artist: String): ArtistInfoResponse {
        return musicApiService.getArtistInfo(artist = artist)
    }

    override suspend fun getAlbum(album: String, artist: String): AlbumResponse {
        return musicApiService.getAlbum(album = album, artist = artist)
    }

    override suspend fun getArtistTopTracks(artist: String): ArtistTopTracksResponse {
        return musicApiService.getArtistTopTracks(artist = artist)
    }

    override suspend fun getArtistTopAlbums(artist: String): ArtistTopAlbumResponse {
        return musicApiService.getArtistTopAlbums(artist = artist)
    }
}