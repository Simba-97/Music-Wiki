package com.simba.musicwiki.data.models.artist_info

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArtistInfoResponse(
    @SerializedName("artist")
    @Expose
    val artist: Artist? = null
) : java.io.Serializable