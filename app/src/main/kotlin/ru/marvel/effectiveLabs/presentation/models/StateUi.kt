package ru.marvel.effectiveLabs.presentation.models

sealed class StateUi {
    object Loading : StateUi()
    object Success : StateUi()
    object Error : StateUi()
}
