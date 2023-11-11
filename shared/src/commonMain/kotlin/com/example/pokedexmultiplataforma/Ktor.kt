package com.example.pokedexmultiplataforma

import com.example.pokedexmultiplataforma.data.model.PokemonApiModel

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class Ktor {


    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun get(): List<PokemonApiModel> {
        return try {
            val result  = httpClient.get("https://pokeapi.co/api/v2/pokemon/?limit=800")
            result.body<PokemonApiModel>().results
        } catch (e: Exception) {
            Log.e("TagDeTuApp", "Ups, ocurrió un error, vuelva a intentarlo más tarde", e)
        }
    }
}