package com.simba.musicwiki.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simba.musicwiki.data.models.album.Image

data class ArtistX(
    @SerializedName("image")
    @Expose
    val image: List<Image>? = null,
    @SerializedName("mbid")
    @Expose
    val mbid: String? = null,
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("streamable")
    @Expose
    val streamable: String? = null,
    @SerializedName("url")
    @Expose
    val url: String? = null
) : java.io.Serializable