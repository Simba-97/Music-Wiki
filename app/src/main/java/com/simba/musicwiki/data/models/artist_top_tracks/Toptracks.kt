package com.simba.musicwiki.data.models.artist_top_tracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Toptracks(
    @SerializedName("track")
    @Expose
    val track: List<Track>? = null
): Serializable