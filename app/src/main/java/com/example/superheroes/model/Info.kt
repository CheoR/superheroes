package com.example.superheroes.model

import com.example.superheroes.R

object HeroesRepository {
    val heroes = listOf(
        Hero(
            stringResourceId = R.string.hero1,
            descriptionRes = R.string.description1,
            imageResourceId = R.drawable.android_superhero1
        ),
        Hero(
            stringResourceId = R.string.hero2,
            descriptionRes = R.string.description2,
            imageResourceId = R.drawable.android_superhero2
        ),
        Hero(
            stringResourceId = R.string.hero3,
            descriptionRes = R.string.description3,
            imageResourceId = R.drawable.android_superhero3
        ),
        Hero(
            stringResourceId = R.string.hero4,
            descriptionRes = R.string.description4,
            imageResourceId = R.drawable.android_superhero4
        ),
        Hero(
            stringResourceId = R.string.hero5,
            descriptionRes = R.string.description5,
            imageResourceId = R.drawable.android_superhero5
        ),
        Hero(
            stringResourceId = R.string.hero6,
            descriptionRes = R.string.description6,
            imageResourceId = R.drawable.android_superhero6
        )
    )
}
