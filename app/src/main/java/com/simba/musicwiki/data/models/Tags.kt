package com.simba.musicwiki.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tags(

    @SerializedName("tag")
    @Expose
    val tag: List<Tag>? = null

) : Serializable