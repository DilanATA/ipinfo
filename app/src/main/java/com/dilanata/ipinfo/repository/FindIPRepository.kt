package com.dilanata.ipinfo.repository

import com.dilanata.ipinfo.api.FindIPApi
import com.dilanata.ipinfo.api.model.IP
import com.dilanata.ipinfo.api.model.ipDetail.IpDetail
import com.dilanata.ipinfo.data.Resource
import com.dilanata.ipinfo.util.Constants.BASE_URL_DETAIL
import com.github.ajalt.timberkt.i
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class FindIPRepository @Inject constructor(
    private val findIPApi: FindIPApi
) {
    fun getFindIp(): Flow<Resource<IP>> {
        return flow {
            emit(Resource.loading(null))
            val getIp = findIPApi.getDeviceIP()
            emit(Resource.success(getIp))
        }.retryWhen { cause, attempt ->
            i { "attempt count -> $attempt" }
            i { "cause -> $cause" }
            (cause is Exception).also { if (it) delay(10_000) }
        }.catch {
            emit(Resource.error(it.localizedMessage, null, it))
        }.flowOn(Dispatchers.IO)
    }

    fun getIpDetail(ip: String) : Flow<Resource<IpDetail>> {
        return flow {
            emit(Resource.loading(null))
            val ipDetail = findIPApi.getIpDetail(
                url = BASE_URL_DETAIL,
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