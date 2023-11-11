package com.example.pokedexmultiplataforma

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun initLogger()

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}