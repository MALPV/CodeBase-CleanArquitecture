package com.malpvaplicaciones.code_cleanarquitecture.ui.main

sealed class MainState{
    object Content: MainState()
    object Loading: MainState()
    data class Error(val message: String): MainState()
}
