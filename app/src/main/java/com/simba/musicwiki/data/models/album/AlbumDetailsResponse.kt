package com.simba.musicwiki.data.models.album

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlbumDetailsResponse(
    @SerializedName("albums")
    @Expose
    val albums: Albums? = null
) : java.io.Serializable