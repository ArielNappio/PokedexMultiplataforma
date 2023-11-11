package com.example.pokedexmultiplataforma.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonApiModel(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)