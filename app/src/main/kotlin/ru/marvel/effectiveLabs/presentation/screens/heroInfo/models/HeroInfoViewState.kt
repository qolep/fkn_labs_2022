package ru.marvel.effectiveLabs.presentation.screens.heroInfo.models

import ru.marvel.effectiveLabs.presentation.models.HeroDataUi
import ru.marvel.effectiveLabs.presentation.models.ViewSubState

data class HeroInfoViewState(
    val heroData: HeroDataUi? = null,
    val subState: ViewSubState = ViewSubState.LOADING
)
