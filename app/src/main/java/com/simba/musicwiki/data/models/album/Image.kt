package com.simba.musicwiki.data.models.album

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("#text")
    @Expose
    val text: String? = null,
    @SerializedName("size")
    @Expose
    val size: String? = null
) : java.io.Serializable