package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @StringRes val stringResourceId: Int,
    val description: Int,
    @DrawableRes val imageResourceId: Int
)
