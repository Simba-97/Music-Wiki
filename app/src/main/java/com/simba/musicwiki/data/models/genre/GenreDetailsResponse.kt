package com.simba.musicwiki.data.models.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenreDetailsResponse(
    @SerializedName("tag")
    @Expose
    val tag: TagX
): Serializable