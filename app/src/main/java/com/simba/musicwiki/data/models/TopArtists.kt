package com.simba.musicwiki.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopArtists(
    @SerializedName("artist")
    @Expose
    val artist: List<ArtistX>? = null
) : java.io.Serializable