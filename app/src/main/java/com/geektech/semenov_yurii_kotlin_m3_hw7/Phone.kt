package com.geektech.semenov_yurii_kotlin_m3_hw7

import android.os.Parcel
import android.os.Parcelable

class Phone(
    var image: Int,
    var title: String,
    var description: String,
    var price: String,
    var color: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(price)
        parcel.writeString(color)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Phone> {
        override fun createFromParcel(parcel: Parcel): Phone {
            return Phone(parcel)
        }

        override fun newArray(size: Int): Array<Phone?> {
            return arrayOfNulls(size)
        }
    }
}