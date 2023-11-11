package com.example.pokedexmultiplataformataller.Data.Models

import com.example.pokedexmultiplataforma.data.model.PokemonApiModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PokedexApiModel (
    @SerialName("results")
    val results: List<PokemonApiModel>
)
