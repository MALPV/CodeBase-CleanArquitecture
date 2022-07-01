package com.malpvaplicaciones.code_cleanarquitecture.ui.main

import androidx.compose.runtime.mutableStateListOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malpvaplicaciones.code_cleanarquitecture.core.util.ResultState
import com.malpvaplicaciones.code_cleanarquitecture.domain.Character
import com.malpvaplicaciones.code_cleanarquitecture.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.xml.transform.Result

class MainVM
@ViewModelInject
constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<MainState>(MainState.Content)
    val uiState = _uiState.asStateFlow()

    val characters = mutableStateListOf<Character>()

    init {
        getCharacters()
    }

    fun resetState() = viewModelScope.launch {
        _uiState.emit(MainState.Content)
    }

    fun getCharacters() = mainRepository.getCharacters().onEach { resultState ->
        when(resultState){
            is ResultState.Success -> {
                characters.clear()
                characters.addAll(resultState.data)
                resetState()
            }
            is ResultState.Loading -> _uiState.value = MainState.Loading
            is ResultState.Error -> _uiState.value = MainState.Error(resultState.message)
        }
    }.launchIn(viewModelScope)

}