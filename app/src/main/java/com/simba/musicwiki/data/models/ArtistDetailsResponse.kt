package com.simba.musicwiki.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArtistDetailsResponse(

    @SerializedName("topartists")
    @Expose
    val topArtists: TopArtists? = null

) : java.io.Serializable