package com.simba.musicwiki.data.models.artist_info

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Bio(
    @SerializedName("content")
    @Expose
    val content: String? = null,

    @SerializedName("published")
    @Expose
    val published: String? = null,

    @SerializedName("summary")
    @Expose
    val summary: String? = null
) : java.io.Serializable