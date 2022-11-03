package com.dilanata.ipinfo.ui.ipDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dilanata.ipinfo.api.model.ipDetail.IpDetail
import com.dilanata.ipinfo.data.Resource
//import com.dilanata.ipinfo.repository.IpDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
/*
@HiltViewModel
class IpDetailVM @Inject constructor(
    private val ipDetailRepository: IpDetailRepository
): ViewModel() {

    private val _ipDetail = MutableLiveData<Resource<IpDetail>>()
    val ipDetail : LiveData<Resource<IpDetail>>
    get() = _ipDetail

    fun getIpDetail(ip: String) {
        viewModelScope.launch {
            ipDetailRepository.getIpDetail(ip = ip).collect {
                _ipDetail.postValue(it)
            }
        }
    }
}*/