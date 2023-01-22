package com.simba.musicwiki.data.models.tracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TrackDetailsResponse(

    @SerializedName("tracks")
    @Expose
    val tracks: Tracks? = null

) : java.io.Serializable