package com.simba.musicwiki.data.models.album

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simba.musicwiki.data.models.album.Album

data class Albums(
    @SerializedName("album")
    @Expose
    val album: List<Album>? = null
) : java.io.Serializable