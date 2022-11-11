package ru.marvel.effectiveLabs.presentation.screens.heroInfo.models

sealed class HeroInfoEvent {
    object PopBack : HeroInfoEvent()
    data class LoadHeroInfo(val value: Int) : HeroInfoEvent()
}
