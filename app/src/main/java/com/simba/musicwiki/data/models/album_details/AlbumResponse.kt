package com.simba.musicwiki.data.models.album_details

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlbumResponse(
    @SerializedName("album")
    @Expose
    val album: Album
): java.io.Serializable