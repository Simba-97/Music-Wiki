package com.simba.musicwiki.data

import com.simba.musicwiki.BuildConfig
import com.simba.musicwiki.data.models.ArtistDetailsResponse
import com.simba.musicwiki.data.models.TagListResponse
import com.simba.musicwiki.data.models.album.AlbumDetailsResponse
import com.simba.musicwiki.data.models.genre.GenreDetailsResponse
import com.simba.musicwiki.data.models.tracks.TrackDetailsResponse
import com.simba.musicwiki.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicApiService {

    @GET(Constants.BASE_URL)
    suspend fun getTopTags(
        @Query("method") method: String = Constants.GET_TOP_TAGS,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("format") format: String = Constants.FORMAT,
        @Query("limit") limit: String = Constants.LIMIT
    ): TagListResponse


    @GET(Constants.BASE_URL)
    suspend fun getDetailsOfGenre(
        @Query("method") method: String = Constants.GENRE_DETAILS,
        @Query("tag") tag: String = "",
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("format") format: String = Constants.FORMAT,
    ): GenreDetailsResponse


    @GET(Constants.BASE_URL)
    suspend fun getDetailsOfAlbum(
        @Query("method") method: String = Constants.ALBUM_DETAILS,
        @Query("tag") tag: String = "",
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("format") format: String = Constants.FORMAT,
    ): AlbumDetailsResponse

    @GET(Constants.BASE_URL)
    suspend fun getDetailsOfArtists(
        @Query("method") method: String = Constants.ARTIST_DETAILS,
        @Query("tag") tag: String = "",
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("format") format: String = Constants.FORMAT,
    ): ArtistDetailsResponse

    @GET(Constants.BASE_URL)
    suspend fun getDetailsOfTracks(
        @Query("method") method: String = Constants.TRACKS_DETAILS,
        @Query("tag") tag: String = "",
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("format") format: String = Constants.FORMAT,
    ): TrackDetailsResponse
}