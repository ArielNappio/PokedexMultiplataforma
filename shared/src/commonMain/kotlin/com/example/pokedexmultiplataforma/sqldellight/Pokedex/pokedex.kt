package com.example.pokedexmultiplataforma.sqldellight.Pokedex



CREATE TABLE Pokedex(
    name TEXT NOT NULL,
    url TEXT NOT NULL
)

insertPokemon:
INSERT INTO Pokedex(name,url) values (?,?);


insertPokemon:
SELECT * FROM Pokedex