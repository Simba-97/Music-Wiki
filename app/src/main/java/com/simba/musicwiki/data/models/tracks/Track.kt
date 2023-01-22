package com.simba.musicwiki.data.models.tracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simba.musicwiki.data.models.ArtistX
import com.simba.musicwiki.data.models.album.Image
import java.io.Serializable

data class Track(
    @SerializedName("artist")
    @Expose
    val artist: ArtistX? = null,

    @SerializedName("duration")
    @Expose
    val duration: String? = null,

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
    val url: String? = null
) : Serializable