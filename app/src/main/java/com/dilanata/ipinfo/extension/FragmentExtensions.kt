package com.dilanata.ipinfo.extension

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import com.dilanata.ipinfo.util.SharedKeys
import com.dilanata.ipinfo.util.SharedKeys.EXTRA_BASE_URL
import com.github.ajalt.timberkt.e


fun Fragment.navigateSafe(
    @IdRes resId: Int,
    bundle: Bundle? = null,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null,
) {
    try {
        findNavController().navigate(
            resId,
            bundle,
            navOptions,
            navigatorExtras
        )
    } catch (exp: Exception) {
        e(exp)
    }
}

var Fragment.baseUrl: String
get () = getSharedPref(EXTRA_BASE_URL, requireContext(), SharedKeys.baseURL)
set (value) {
    saveSharedPref(EXTRA_BASE_URL, requireContext(), baseUrl, value)
}