package com.example.effective_lab

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument



sealed class Destination(val route: String) {
    object ScreenStart : Destination("ScreenStart")
    object HeroInfoScreen : Destination("HeroInfoScreen/{$ID}"){
        fun passID(id:Int):String{
            return  "Start/$id"
        }
    }

}

const val ID="id"

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "ScreenStart") {
        composable(Destination.ScreenStart.route) { StartScreen(navController) }
        composable(Destination.HeroInfoScreen.route, arguments = listOf(navArgument(ID){
            type= NavType.IntType
        })) {
            HeroInfoScreen(navController, it.arguments?.getInt(ID)?:0) }
    }
}


