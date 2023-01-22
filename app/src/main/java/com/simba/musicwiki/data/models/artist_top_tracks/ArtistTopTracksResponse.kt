package com.simba.musicwiki.data.models.artist_top_tracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArtistTopTracksResponse(

    @SerializedName("toptracks")
    @Expose
    val toptracks: Toptracks? = null

) : java.io.Serializable