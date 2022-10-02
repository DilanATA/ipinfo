package com.dilanata.ipinfo.api.model.ipDetail

data class ipDetail(
    val geoplugin_areaCode: String,
    val geoplugin_city: String,
    val geoplugin_continentCode: String,
    val geoplugin_continentName: String,
    val geoplugin_countryCode: String,
    val geoplugin_countryName: String,
    val geoplugin_credit: String,
    val geoplugin_currencyCode: String,
    val geoplugin_currencyConverter: Double,
    val geoplugin_currencySymbol: String,
    val geoplugin_currencySymbol_UTF8: String,
    val geoplugin_delay: String,
    val geoplugin_dmaCode: String,
    val geoplugin_euVATrate: Boolean,
    val geoplugin_inEU: Int,
    val geoplugin_latitude: String,
    val geoplugin_locationAccuracyRadius: String,
    val geoplugin_longitude: String,
    val geoplugin_region: String,
    val geoplugin_regionCode: String,
    val geoplugin_regionName: String,
    val geoplugin_request: String,
    val geoplugin_status: Int,
    val geoplugin_timezone: String
)