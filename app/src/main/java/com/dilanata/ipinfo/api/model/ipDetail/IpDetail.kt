package com.dilanata.ipinfo.api.model.ipDetail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class IpDetail(
    @SerialName("geoplugin_areaCode")
    var geoplugin_areaCode: String,
    @SerialName("geoplugin_city")
    var geoplugin_city: String,
    @SerialName("geoplugin_continentCode")
    var geoplugin_continentCode: String,
    @SerialName("geoplugin_continentName")
    var geoplugin_continentName: String,
    @SerialName("geoplugin_countryCode")
    var geoplugin_countryCode: String,
    @SerialName("geoplugin_countryName")
    var geoplugin_countryName: String,
    @SerialName("geoplugin_credit")
    var geoplugin_credit: String,
    @SerialName("geoplugin_currencyCode")
    var geoplugin_currencyCode: String,
    @SerialName("geoplugin_currencyConverter")
    var geoplugin_currencyConverter: Double,
    @SerialName("geoplugin_currencySymbol")
    var geoplugin_currencySymbol: String,
    @SerialName("geoplugin_currencySymbol_UTF8")
    var geoplugin_currencySymbol_UTF8: String,
    @SerialName("geoplugin_delay")
    var geoplugin_delay: String,
    @SerialName("geoplugin_dmaCode")
    var geoplugin_dmaCode: String,
    @SerialName("geoplugin_euVATrate")
    var geoplugin_euVATrate: Boolean,
    @SerialName("geoplugin_inEU")
    var geoplugin_inEU: Int,
    @SerialName("geoplugin_latitude")
    var geoplugin_latitude: String,
    @SerialName("geoplugin_locationAccuracyRadius")
    var geoplugin_locationAccuracyRadius: String,
    @SerialName("geoplugin_longitude")
    var geoplugin_longitude: String,
    @SerialName("geoplugin_region")
    var geoplugin_region: String,
    @SerialName("geoplugin_regionCode")
    var geoplugin_regionCode: String,
    @SerialName("geoplugin_regionName")
    var geoplugin_regionName: String,
    @SerialName("geoplugin_request")
    var geoplugin_request: String,
    @SerialName("geoplugin_status")
    var geoplugin_status: Int,
    @SerialName("geoplugin_timezone")
    var geoplugin_timezone: String
): Parcelable