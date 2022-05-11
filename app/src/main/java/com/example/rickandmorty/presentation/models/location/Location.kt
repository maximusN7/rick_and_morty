package com.example.rickandmorty.presentation.models.location

import kotlinx.android.parcel.Parcelize

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<Int>?
)