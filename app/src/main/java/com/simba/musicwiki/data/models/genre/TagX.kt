package com.simba.musicwiki.data.models.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TagX(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("reach")
    @Expose
    val reach: Int,
    @SerializedName("total")
    @Expose
    val total: Int,
    @SerializedName("wiki")
    @Expose
    val wiki: Wiki
) : java.io.Serializable