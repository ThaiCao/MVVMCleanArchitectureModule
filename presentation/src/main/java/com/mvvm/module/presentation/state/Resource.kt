package com.mvvm.module.presentation.state

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
}