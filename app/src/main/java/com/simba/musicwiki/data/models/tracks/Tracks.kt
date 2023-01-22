package com.simba.musicwiki.data.models.tracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tracks(
    @SerializedName("track")
    @Expose
    val track: List<Track>? = null
) : Serializable