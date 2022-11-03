package com.dilanata.ipinfo.ui.ipDetail

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import com.dilanata.ipinfo.R
import com.dilanata.ipinfo.api.IpDetailApi
import com.dilanata.ipinfo.api.model.ipDetail.IpDetail
import com.dilanata.ipinfo.base.BaseFragment
import com.dilanata.ipinfo.data.Status
import com.dilanata.ipinfo.databinding.FragmentIpDetailBinding
import com.dilanata.ipinfo.ui.findIp.FindIpVM
import com.github.ajalt.timberkt.i
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@Suppress("COMPATIBILITY_WARNING")
@ExperimentalCoroutinesApi
@FlowPreview
@AndroidEntryPoint
class IpDetailFragment : BaseFragment<FragmentIpDetailBinding>(R.layout.fragment_ip_detail) {

    lateinit var ipDetail: IpDetail

    private val findIpVM: FindIpVM by navGraphViewModels(R.id.nav_graph) {
        defaultViewModelProviderFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findIpVM.getIpDetail("88.231.200.64")
        findIpVM.ipDetail.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    ipDetail = it.data!!
                }
                Status.ERROR -> i { "error ${it.throwable}" }
                Status.LOADING -> i { "Loading" }
            }

        }
    }
}