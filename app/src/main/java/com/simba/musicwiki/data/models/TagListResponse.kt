package com.simba.musicwiki.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TagListResponse(

    @SerializedName("tags")
    @Expose
    val tags: Tags? = null

) : Serializable