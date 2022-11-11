package ru.marvel.effectiveLabs.navigation

import androidx.navigation.NavHostController

class AppNavigationImpl : AppNavigation {
    override var navHostController: NavHostController? = null

    override fun navigateTo(appScreen: AppScreens, arg: String?) {
        val route = "${appScreen.route}/$arg"
        navHostController?.navigate(route)
    }

    override fun navigateTo(appScreen: AppScreens) {
        navHostController?.navigate(appScreen.route)
    }

    override fun popBackStack() {
        navHostController?.popBackStack()
    }
}
