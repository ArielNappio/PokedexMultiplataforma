package com.example.pokedexmultiplataforma.android.UI
import com.example.pokedexmultiplataforma.data.model.PokemonApiModel
import com.example.pokedexmultiplatform.serializable.PokemonApiModel

sealed ScreenState {

    object Loading : ScreenState()

    object Error : ScreenState()

    class Success(val pokemonList : List<PokemonApiModel>) : ScreenState()
}