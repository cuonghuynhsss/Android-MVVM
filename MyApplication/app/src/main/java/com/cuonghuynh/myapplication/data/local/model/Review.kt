package com.cuonghuynh.myapplication.data.local.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * @author Yassin Ajdi
 * @since 11/13/2018.
 */
@Entity(tableName = "review",
        foreignKeys = [ForeignKey(entity = Movie::class,
                parentColumns = ["id"],
                childColumns = ["movie_id"],
                onDelete = CASCADE,
                onUpdate = CASCADE)],
        indices = [Index(value = ["movie_id"])])
data class Review (
    @PrimaryKey
    @SerializedName("id")
    var id: String,

    @ColumnInfo(name = "movie_id")
    var movieId: Long = 0,

    @SerializedName("author")
    var author: String? = null,

    @SerializedName("content")
    var content: String? = null,

    @SerializedName("url")
    var url: String? = null
)
