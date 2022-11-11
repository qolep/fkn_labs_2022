package ru.marvel.effectiveLabs.data.repository

import ru.marvel.effectiveLabs.data.models.Resource
import ru.marvel.effectiveLabs.presentation.models.HeroDataUi

interface Repository {
    suspend fun getHeroesList(): Resource<List<HeroDataUi>>
    suspend fun getHeroInfo(id: Int): Resource<HeroDataUi>
}
