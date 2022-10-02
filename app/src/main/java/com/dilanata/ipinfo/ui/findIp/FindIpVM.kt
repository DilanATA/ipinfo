package com.dilanata.ipinfo.ui.findIp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dilanata.ipinfo.api.model.IP
import com.dilanata.ipinfo.data.Resource
import com.dilanata.ipinfo.repository.FindIPRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindIpVM @Inject constructor(
    private val findIPRepository: FindIPRepository
): ViewModel() {
    private val _ip = MutableLiveData<Resource<IP>>()
    val ip: LiveData<Resource<IP>>
    get() = _ip

    fun getIp() {
        viewModelScope.launch {
            findIPRepository.getFindIp().collect {
                _ip.postValue(it)
            }
        }
    }
}