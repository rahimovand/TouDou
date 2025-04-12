package com.example.toudou.destinations

sealed class Screens(val name: String) {
    object MainScreen : Screens("Main")
    object AddScreen : Screens("Add")
}