package com.example.pokedexmultiplataforma.android.Inyeccion

import com.example.pokedexmultiplataforma.android.viewModel.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun androidModule() = module{
    viewModel{PokedexViewModel(get())}
}