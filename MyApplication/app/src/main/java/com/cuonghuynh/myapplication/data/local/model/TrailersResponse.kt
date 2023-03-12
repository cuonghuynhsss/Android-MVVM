package com.cuonghuynh.myapplication.data.local.model

import com.google.gson.annotations.SerializedName

/**
 * @author Yassin Ajdi.
 */
data class TrailersResponse (

    @SerializedName("results")
    var trailers: List<Trailer>? = null
)
