package com.simba.musicwiki.data.models.artist_top_albums

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simba.musicwiki.data.models.album_details.Album

data class TopAlbums(
    @SerializedName("album")
    @Expose
    val album: List<Album>? = null
)