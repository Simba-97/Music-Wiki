package com.simba.musicwiki.data.models.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Wiki(
    @SerializedName("content")
    @Expose
    val content: String,
    @SerializedName("summary")
    @Expose
    val summary: String
) : Serializable