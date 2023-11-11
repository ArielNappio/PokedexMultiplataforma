package com.example.pokedexmultiplataforma.Injeccion

import com.example.pokedexmultiplataforma.Ktor
import com.example.pokedexmultiplataforma.Repository.PokedexRepo
import com.example.pokedexmultiplataforma.Repository.PokedexRepository
import kotlin.collections.EmptyList.get
import kotlin.collections.EmptyMap.get


class module = module {
    single { Ktor() }
    single<PokedexRepo> { PokedexRepository(get()) }
}