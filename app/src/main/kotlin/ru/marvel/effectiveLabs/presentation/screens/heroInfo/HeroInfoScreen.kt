package ru.marvel.effectiveLabs.presentation.screens.heroInfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import ru.marvel.effectiveLabs.presentation.screens.components.LoadingView
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.marvel.effectiveLabs.presentation.models.StateUi
import ru.marvel.effectiveLabs.presentation.screens.heroInfo.models.HeroInfoEvent
import ru.marvel.effectiveLabs.presentation.screens.heroInfo.components.HeroInfoView
import ru.marvel.effectiveLabs.presentation.screens.heroInfo.components.HeroScreenTopBar
import ru.marvel.effectiveLabs.presentation.screens.components.ErrorView
import ru.marvel.effectiveLabs.presentation.screens.heroInfo.models.HeroInfoViewModel


@Composable
fun HeroInfoScreen(viewModel: HeroInfoViewModel = viewModel(), id: Int) {

    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        viewModel.obtainEvent(HeroInfoEvent.LoadHeroInfo(id))
    })

    when (uiState.value.stateUi) {
        StateUi.Error -> ErrorView()
        StateUi.Loading -> LoadingView()
        StateUi.Success -> HeroInfoView(heroInfo = uiState.value.heroInfo!!)
    }

    HeroScreenTopBar {

        viewModel.obtainEvent(HeroInfoEvent.PopBack)
    }
}
