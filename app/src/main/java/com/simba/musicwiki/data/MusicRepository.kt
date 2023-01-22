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
import javax.inject.Inject

interface MusicRepository {
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

    override suspend fun getArtistInfo(artist: String): ArtistInfoResponse {
        return musicRemoteDataSource.getArtistInfo(artist = artist)
    }

    override suspend fun getAlbum(album: String, artist: String): AlbumResponse {
        return musicRemoteDataSource.getAlbum(album = album, artist = artist)
    }

    override suspend fun getArtistTopTracks(artist: String): ArtistTopTracksResponse {
        return musicRemoteDataSource.getArtistTopTracks(artist = artist)
    }

    override suspend fun getArtistTopAlbums(artist: String): ArtistTopAlbumResponse {
        return musicRemoteDataSource.getArtistTopAlbums(artist = artist)
    }
}