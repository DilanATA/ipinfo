package com.dilanata.ipinfo.api.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class IP(
    @SerialName("ip")
    var ip: String
): Parcelable