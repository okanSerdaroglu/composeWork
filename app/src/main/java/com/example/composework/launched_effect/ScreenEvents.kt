package com.example.composework.launched_effect

sealed class ScreenEvents {
    data class ShowSnackBar(val message: String) : ScreenEvents()

    data class Navigate(val route: String) : ScreenEvents()
}
