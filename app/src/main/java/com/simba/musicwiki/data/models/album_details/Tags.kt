package com.simba.musicwiki.data.models.album_details

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.simba.musicwiki.data.models.Tag

data class Tags(
    @SerializedName("tag")
    @Expose
    val tag: List<Tag>
)