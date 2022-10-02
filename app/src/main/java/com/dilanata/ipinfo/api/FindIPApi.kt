package com.dilanata.ipinfo.api

import com.dilanata.ipinfo.api.model.IP
import retrofit2.http.GET

interface FindIPApi {

    @GET("?format=json")
    suspend fun getDeviceIP() : IP
}