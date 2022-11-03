package com.dilanata.ipinfo.api

import com.dilanata.ipinfo.api.model.ipDetail.IpDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface IpDetailApi {
    //http://www.geoplugin.net/json.gp?ip=78.176.215.230
    @GET("json.gp?{ip}")
    suspend fun getIpDetail(
        @Path("ip") ip: String
    ) : IpDetail
}