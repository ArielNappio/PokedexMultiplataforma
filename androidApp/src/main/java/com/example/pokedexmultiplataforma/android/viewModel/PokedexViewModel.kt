package com.example.pokedexmultiplataforma.android.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmultiplataforma.Repository.PokedexRepo
import kotlinx.coroutines.launch

class PokedexViewModel (private val pokedexRepo :PokedexRepo) : ViewModel(){
    private val pokedexObs : MutableLiveData<ScreenState>(ScreenState.loading)
    val pokedex : MutableLiveData<ScreenState> = pokedexObs


    init{
        listPokemon()
    }

   private fun listPokemon(){
        viewModelScope.launch {
            val ktor = pokedexRepo.getPokedex()
            pokedex.value = ScreenState.Success(ktor)
        }
    }

}