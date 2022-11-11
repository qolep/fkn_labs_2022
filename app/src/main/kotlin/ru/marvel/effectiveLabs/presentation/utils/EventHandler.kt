package ru.marvel.effectiveLabs.presentation.utils

interface EventHandler<E> {
    fun obtainEvent(event: E)
}
