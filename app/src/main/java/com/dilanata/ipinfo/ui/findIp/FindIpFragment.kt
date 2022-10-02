package com.dilanata.ipinfo.ui.findIp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.dilanata.ipinfo.R
import com.dilanata.ipinfo.api.model.IP
import com.dilanata.ipinfo.base.BaseFragment
import com.dilanata.ipinfo.data.Status
import com.dilanata.ipinfo.databinding.FragmentFindIpBinding
import com.github.ajalt.timberkt.i
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@Suppress("COMPATIBILITY_WARNING")
@ExperimentalCoroutinesApi
@FlowPreview
@AndroidEntryPoint
class FindIpFragment : BaseFragment<FragmentFindIpBinding>(R.layout.fragment_find_ip) {

    lateinit var ip: IP

    private val findIpVM: FindIpVM by navGraphViewModels(R.id.nav_graph) {
        defaultViewModelProviderFactory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findIpVM.getIp()

        findIpVM.ip.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    ip = it.data!!
                    binding.ip = ip
                }
                Status.ERROR -> i { "error ${it.throwable}" }
                Status.LOADING -> i { "Loading" }
            }
        }
    }

}