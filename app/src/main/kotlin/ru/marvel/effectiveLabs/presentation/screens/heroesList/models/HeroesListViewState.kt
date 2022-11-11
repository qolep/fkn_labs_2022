package ru.marvel.effectiveLabs.presentation.screens.heroesList.models

import ru.marvel.effectiveLabs.presentation.models.HeroDataUi
import ru.marvel.effectiveLabs.presentation.models.ViewSubState

data class HeroesListViewState(
    val heroesList: List<HeroDataUi> = emptyList(),
    val subState: ViewSubState = ViewSubState.LOADING,
)
