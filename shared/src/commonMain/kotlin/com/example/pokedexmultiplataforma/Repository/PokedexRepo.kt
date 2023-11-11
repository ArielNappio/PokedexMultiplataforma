package com.example.pokedexmultiplataforma.Repository

import com.example.pokedexmultiplataforma.data.model.PokemonApiModel


interface PokedexRepo {
        suspend fun getPokedex()
}
