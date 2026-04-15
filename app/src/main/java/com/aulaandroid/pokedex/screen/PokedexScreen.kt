package com.aulaandroid.pokedex.screen

import android.R.attr.contentDescription
import android.R.attr.text
import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulaandroid.pokedex.R
import com.aulaandroid.pokedex.component.PokemonCard
import com.aulaandroid.pokedex.model.Pokemon
import com.aulaandroid.pokedex.viewModel.PokemonViewModel

@Composable
fun PokedexScreen(
    viewModelCompartilhado: PokemonViewModel,
    pokemonList: List<Pokemon>,
    navController: NavController,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xE2D0D7D0)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color.Red),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "Logo pokedex",
                modifier = Modifier.size(80.dp)
                    .padding(8.dp)
            )

            Text(
                text = "Pokédex",
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp)
                .border(3.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
                .clip(shape = RoundedCornerShape(10.dp))
                .background(Color.White)
                ,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.weight(2f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Words
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    disabledBorderColor = Color.Transparent
                ),
                placeholder = {
                    Text(text = "Nome ou ID", fontSize = 16.sp)
                }
            )

            IconButton(onClick={

            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Pesquisando",
                    tint = Color.Red
                )
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(pokemonList){index, pokemon ->
                if (index >= pokemonList.size -3 && !viewModelCompartilhado.isLoading){
                    viewModelCompartilhado.carregarListaPokemon()
                }

                PokemonCard(pokemon = pokemon, aoClicar = {

                })
            }
        }


    }
}