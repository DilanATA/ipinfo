package com.dilanata.ipinfo.repository

import com.dilanata.ipinfo.api.IpDetailApi
import com.dilanata.ipinfo.api.model.ipDetail.IpDetail
import com.dilanata.ipinfo.data.Resource
import com.github.ajalt.timberkt.i
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

import javax.inject.Inject

class IpDetailRepository @Inject constructor(
    private val ipDetailApi: IpDetailApi
){
    fun getIpDetail(ip: String) : Flow<Resource<IpDetail>> {
        return flow {
            emit(Resource.loading(null))
            val ipDetail = ipDetailApi.getIpDetail(
                ip = ip
            )
            emit(Resource.success(ipDetail))
        }.retryWhen { cause, attempt ->
            i { "attempt count -> $attempt" }
            i { "cause -> $cause" }
            (cause is Exception).also { if (it) delay(10_000) }
        }.catch {
            emit(Resource.error(it.localizedMessage, null, it))
        }.flowOn(Dispatchers.IO)
    }
}