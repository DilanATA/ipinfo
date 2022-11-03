package com.dilanata.ipinfo.api

import com.dilanata.ipinfo.api.model.IP
import com.dilanata.ipinfo.api.model.ipDetail.IpDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface FindIPApi {

    @GET("?format=json")
    suspend fun getDeviceIP() : IP

    @GET
    suspend fun getIpDetail(
        @Url url: String,
        @Query("ip") ip: String
    ) : IpDetail
}