package com.example.pokedexmultiplataforma.Repository

import com.example.pokedexmultiplataforma.Ktor
import com.example.pokedexmultiplataforma.data.model.PokemonApiModel


class PokedexRepository(private val ktorService: Ktor) : PokedexRepo {
    override suspend fun getPokedex(): List<PokemonApiModel> {
        if (ktorService.get().isNotEmpty()) {
            ktorService.get().map { ite ->
                PokemonApiModel(ite.name, ite.name)
            }
        }
        return emptyList()
    }
}