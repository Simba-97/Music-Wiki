package com.simba.musicwiki.data

import com.simba.musicwiki.BuildConfig
import com.simba.musicwiki.data.models.TagListResponse
import com.simba.musicwiki.utils.Constants
import retrofit2.http.Query

interface MusicApiService {

    suspend fun getTopTags(
        @Query("method") method: String = Constants.GET_TOP_TAGS,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("format") format: String = Constants.FORMAT
    ): TagListResponse
}