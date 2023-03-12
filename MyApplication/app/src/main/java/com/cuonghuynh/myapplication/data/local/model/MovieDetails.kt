package com.cuonghuynh.myapplication.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

/**
 * This class is used to load full movie details including (Trailers, Cast, etc)
 *
 * @author Yassin Ajdi
 * @since 11/12/2018.
 */
data class MovieDetails (

    @Embedded
    var movie: Movie? = null,

    @Relation(parentColumn = "id", entityColumn = "movie_id")
    var trailers: List<Trailer> = ArrayList(),

    @Relation(parentColumn = "id", entityColumn = "movie_id")
    var castList: List<Cast> = ArrayList(),

    @Relation(parentColumn = "id", entityColumn = "movie_id")
    var reviews: List<Review> = ArrayList()
)
