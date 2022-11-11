package ru.marvel.effectiveLabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.marvel.effectiveLabs.presentation.models.AppNavHost
import ru.marvel.effectiveLabs.navigation.AppNavigation
import ru.marvel.effectiveLabs.presentation.screens.components.TransparentSystemBars
import ru.marvel.effectiveLabs.ui.theme.EffectiveLabsTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigation: AppNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val navController = rememberNavController()
            navigation.navHostController = navController
            EffectiveLabsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.secondary
                ) {
                    TransparentSystemBars()
                    AppNavHost(navController = navController)
                }
            }
        }
    }
}
