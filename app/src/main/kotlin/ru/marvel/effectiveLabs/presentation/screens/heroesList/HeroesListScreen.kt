package ru.marvel.effectiveLabs.presentation.screens.heroesList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.marvel.effectiveLabs.R
import ru.marvel.effectiveLabs.presentation.models.StateUi
import ru.marvel.effectiveLabs.presentation.screens.components.ErrorView
import ru.marvel.effectiveLabs.presentation.screens.components.LoadingView
import ru.marvel.effectiveLabs.presentation.screens.heroesList.components.BackgroundTriangle
import ru.marvel.effectiveLabs.presentation.screens.heroesList.components.HeroesListView
import ru.marvel.effectiveLabs.presentation.screens.heroesList.models.HeroesListEvent
import ru.marvel.effectiveLabs.presentation.screens.heroesList.models.HeroesListViewModel
import ru.marvel.effectiveLabs.presentation.utils.orientationValue
import ru.marvel.effectiveLabs.ui.consts.heroesListColumnPaddingLandscape
import ru.marvel.effectiveLabs.ui.consts.heroesListColumnPaddingPortrait
import ru.marvel.effectiveLabs.ui.consts.heroesListImagePaddingLandscape
import ru.marvel.effectiveLabs.ui.consts.heroesListImagePaddingPortrait

private const val LANDSCAPE_IMAGE_WIDTH = 0.2f
private const val PORTRAIT_IMAGE_WIDTH = 1 / 3f


@Composable
fun HeroesListScreen(viewModel: HeroesListViewModel = viewModel()) {

    val uiState = viewModel.uiState.collectAsState()

    BackgroundTriangle(Color.Red)

    LaunchedEffect(key1 = Unit, block = {
        viewModel.obtainEvent(HeroesListEvent.LoadHeroesList)
    })

    Column(
        modifier = orientationValue(
            landscapeValue = Modifier.padding(heroesListColumnPaddingLandscape),
            portraitValue = Modifier.padding(heroesListColumnPaddingPortrait)
        ) as Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = orientationValue(
                landscapeValue = Modifier
                    .fillMaxWidth(LANDSCAPE_IMAGE_WIDTH)
                    .padding(heroesListImagePaddingLandscape),
                portraitValue = Modifier
                    .fillMaxWidth(PORTRAIT_IMAGE_WIDTH)
                    .padding(heroesListImagePaddingPortrait)
            ) as Modifier,
            painter = painterResource(id = R.drawable.marvel),
            contentDescription = stringResource(id = R.string.cd_main_banner)
        )

        when(uiState.value.stateUi){
            StateUi.Error -> ErrorView()
            StateUi.Loading -> LoadingView()
            StateUi.Success -> HeroesListView(uiState.value.heroesList) {
                viewModel.obtainEvent(HeroesListEvent.OpenHeroInfo(it))
            }
        }
    }
}
