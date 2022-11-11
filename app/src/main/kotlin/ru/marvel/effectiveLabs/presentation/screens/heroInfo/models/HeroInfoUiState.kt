package ru.marvel.effectiveLabs.presentation.screens.heroInfo.models

import ru.marvel.effectiveLabs.presentation.models.HeroDataUi
import ru.marvel.effectiveLabs.presentation.models.StateUi

data class HeroInfoUiState(
    val heroInfo: HeroDataUi? = null,
    val stateUi : StateUi = StateUi.Loading

) {
    companion object {
        val Empty = HeroInfoUiState()
    }
}


