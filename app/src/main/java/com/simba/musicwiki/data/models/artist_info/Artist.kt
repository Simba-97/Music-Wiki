package com.simba.musicwiki.data.models.artist_info

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simba.musicwiki.data.models.album.Image
import com.simba.musicwiki.data.models.album_details.Tags

data class Artist(
    @SerializedName("bio")
    @Expose
    val bio: Bio? = null,

    @SerializedName("image")
    @Expose
    val image: List<Image>? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("stats")
    @Expose
    val stats: Stats? = null,

    @SerializedName("tags")
    @Expose
    val tags: Tags? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null
) : java.io.Serializable