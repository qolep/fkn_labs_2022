package ru.marvel.effectiveLabs.presentation.screens.heroesList.models

import ru.marvel.effectiveLabs.presentation.models.HeroDataUi
import ru.marvel.effectiveLabs.presentation.models.StateUi

data class HeroesListUiState (
    val heroesList: List<HeroDataUi> = emptyList(),
    val stateUi: StateUi = StateUi.Loading
) {
    companion object {
        val Empty = HeroesListUiState()
    }
}




