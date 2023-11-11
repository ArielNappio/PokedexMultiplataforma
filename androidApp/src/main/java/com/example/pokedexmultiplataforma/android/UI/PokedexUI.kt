package com.example.pokedexmultiplataforma.android.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R
import com.example.pokedexmultiplataforma.ImageBuilder
import com.example.pokedexmultiplataforma.android.viewModel.PokedexViewModel
import com.example.pokedexmultiplataforma.data.model.PokemonApiModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun CardItem(
  pokemonApiModel: PokemonApiModel
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 13.dp)
            .size(170.dp, height = 130.dp)
    ) {
        Column(Modifier.padding(8.dp)) {
            Column {
                AsyncImage(
                    model = ImageBuilder.buildPokemonImageByUrl(pokemonApiModel.url),
                    pokemonApiModel.name,
                    placeholder = painterResource(id = img),
                    modifier = Modifier
                        .size(150.dp, 80.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = pokemonApiModel.name,
                    modifier = Modifier
                        .padding(8.dp),
                    color = Color.DarkGray,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}