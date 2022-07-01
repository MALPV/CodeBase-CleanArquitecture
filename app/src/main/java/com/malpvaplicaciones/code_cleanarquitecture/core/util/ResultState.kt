package com.malpvaplicaciones.code_cleanarquitecture.core.util


sealed class ResultState<out R>{
    data class Success<out T>(val data: T): ResultState<T>()
    data class Error(val message: String): ResultState<Nothing>()
    object Loading: ResultState<Nothing>()
}