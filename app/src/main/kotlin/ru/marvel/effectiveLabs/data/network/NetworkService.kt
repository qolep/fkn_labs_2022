package ru.marvel.effectiveLabs.data.network

import ru.marvel.effectiveLabs.data.models.Resource
import ru.marvel.effectiveLabs.data.network.model.Result

interface NetworkService {
    suspend fun getCharacterList(): Resource<List<Result>>
    suspend fun getCharacterInfo(id: Int): Resource<Result>
}
