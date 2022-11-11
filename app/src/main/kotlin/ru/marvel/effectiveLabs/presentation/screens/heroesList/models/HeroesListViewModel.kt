package ru.marvel.effectiveLabs.presentation.screens.heroesList.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.marvel.effectiveLabs.data.models.Resource
import ru.marvel.effectiveLabs.navigation.AppNavigation
import ru.marvel.effectiveLabs.navigation.AppScreens
import ru.marvel.effectiveLabs.data.repository.Repository
import ru.marvel.effectiveLabs.presentation.models.StateUi
import ru.marvel.effectiveLabs.presentation.utils.EventHandler
import javax.inject.Inject

@HiltViewModel
class HeroesListViewModel @Inject constructor(
    private val navigation: AppNavigation,
    private val repository: Repository,
) : ViewModel(), EventHandler<HeroesListEvent> {

    private val _uiState = MutableStateFlow(HeroesListUiState.Empty)
    val uiState : StateFlow<HeroesListUiState> = _uiState.asStateFlow()

    override fun obtainEvent(event: HeroesListEvent) {
        when (event) {
            HeroesListEvent.LoadHeroesList -> getHeroesList()
            is HeroesListEvent.OpenHeroInfo -> openHeroInfo(event.value)
        }
    }

    private fun getHeroesList() {

        viewModelScope.launch {

            when(val heroesList = repository.getHeroesList()){
                is Resource.Error -> _uiState.update { it.copy(stateUi = StateUi.Error)}
                is Resource.Success -> _uiState.update {
                    it.copy(stateUi = StateUi.Success, heroesList = heroesList.data!!)}
            }
        }
    }

    private fun openHeroInfo(id: Int) {
        navigation.navigateTo(AppScreens.HeroInfoScreen, id.toString())
    }
}
