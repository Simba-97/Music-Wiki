package com.simba.musicwiki.data.models.album_details

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simba.musicwiki.data.models.album.Image
import com.simba.musicwiki.data.models.genre.Wiki

data class AlbumResponse(
    @SerializedName("album")
    @Expose
    val album: Album
) : java.io.Serializable

data class Album(
    @SerializedName("artist")
    @Expose
    val artist: String? = null,

    @SerializedName("image")
    @Expose
    val image: List<Image>? = null,

    @SerializedName("mbid")
    @Expose
    val mbid: String? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("tags")
    @Expose
    val tags: Tags? = null,

    @SerializedName("wiki")
    @Expose
    val wiki: Wiki? = null
)