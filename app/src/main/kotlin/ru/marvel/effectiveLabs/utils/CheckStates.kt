package ru.marvel.effectiveLabs.utils

import android.content.Context
import android.net.ConnectivityManager

fun hasInternetConnection(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if (capabilities != null) {
        return true
    }
    return false
}
