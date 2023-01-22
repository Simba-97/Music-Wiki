package com.simba.musicwiki.data.models.artist_top_albums

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArtistTopAlbumResponse(
    @SerializedName("topalbums")
    @Expose
    val topAlbums: TopAlbums? = null
): java.io.Serializable