package com.simba.musicwiki.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tag(

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("reach")
    @Expose
    val reach: String? = null,

    @SerializedName("streamable")
    @Expose
    val streamable: String? = null,

    @SerializedName("taggings")
    @Expose
    val taggings: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,
) : Serializable