package com.aulaandroid.pokedex.component

import android.R
import android.R.attr.contentDescription
import android.R.attr.text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.aulaandroid.pokedex.model.Pokemon
import com.aulaandroid.pokedex.ui.theme.obterCorPorTipo

@Composable
fun PokemonCard(pokemon: Pokemon,
                modifier: Modifier = Modifier,
                aoClicar: () -> Unit = {}
) {
    val nomeDoPrimeiroTipo = pokemon.nomesDosTipos.firstOrNull()

    val corDoFundo = obterCorPorTipo(nomeDoPrimeiroTipo)


    Card(
        modifier = modifier.fillMaxWidth()
            .aspectRatio(0.75F)
            .clickable{ aoClicar()},
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = corDoFundo)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "#${pokemon.id.toString().padStart(3, '0')}",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                fontSize = 12.sp,
                color = Color.Gray
            )

            AsyncImage(
                model = pokemon.sprites?.other?.officialArtwork?.frontDefault,
                contentDescription = "Imagem do pokemon ${pokemon.name}",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Text(
                text = pokemon.name.replaceFirstChar {it.uppercase()},
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black
            )
        }
    }
}