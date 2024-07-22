package com.linkdev.apitask.network.response

import com.google.gson.annotations.SerializedName

data class NowPlayingResponse(
    @SerializedName("page")
    val page: Int? = null,

    @SerializedName("total_pages")
    val totalPages: Int? = null,

    @SerializedName("total_results")
    val totalResults: Int? = null,

    @SerializedName("results")
    val results: ArrayList<Movies>? = null
)
