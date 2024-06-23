package com.example.testlime.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testlime.domain.Tv

@Entity(
    tableName = "tvs"
)

data class TvDbEntity(
    @PrimaryKey val name_ru: String,
    val image: String,
    val url: String,
    val is_favourite: Boolean
) {
    fun toTvDb(): Tv {
        return Tv(
            name_ru = name_ru,
            image = image,
            url = url,
            is_favourite = is_favourite
        )
    }
}

fun TvJson.fromTvToTvDbEntity(isFavourite: Boolean): TvDbEntity = TvDbEntity(
    name_ru = this.name_ru,
    image = this.image ?: "",
    url = this.url,
    is_favourite = isFavourite
)