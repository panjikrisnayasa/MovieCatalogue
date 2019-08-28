package com.panjikrisnayasa.moviecatalogue.MovieList

import android.os.Parcel
import android.os.Parcelable

data class MovieModel(
    var poster: Int = 0,
    var title: String? = "",
    var ratingScore: Float = 0f,
    var genre: String? = "",
    var duration: String? = "",
    var rating: String? = "",
    var synopsis: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(poster)
        parcel.writeString(title)
        parcel.writeFloat(ratingScore)
        parcel.writeString(genre)
        parcel.writeString(duration)
        parcel.writeString(rating)
        parcel.writeString(synopsis)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }
}
