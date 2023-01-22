package com.simba.musicwiki.data.models.artist_top_tracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simba.musicwiki.data.models.album.Artist
import com.simba.musicwiki.data.models.album.Image
import java.io.Serializable

data class Track(
    @SerializedName("artist")
    @Expose
    val artist: Artist? = null,

    @SerializedName("image")
    @Expose
    val image: List<Image>? = null,

    @SerializedName("listeners")
    @Expose
    val listeners: String? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("playcount")
    @Expose
    val playcount: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null
) : Serializable