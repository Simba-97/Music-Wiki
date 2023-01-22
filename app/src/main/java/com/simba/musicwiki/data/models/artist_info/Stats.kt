package com.simba.musicwiki.data.models.artist_info

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("listeners")
    @Expose
    val listeners: String? = null,

    @SerializedName("playcount")
    @Expose
    val playcount: String? = null
) : java.io.Serializable