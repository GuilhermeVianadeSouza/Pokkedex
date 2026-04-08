package com.aulaandroid.pokedex.screen

import android.R.attr.contentDescription
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulaandroid.pokedex.R

@Composable
fun PokedexScreen(
    navController: NavController,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color.Red)

        ) {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "Logo pokedex",
                modifier = Modifier.size(120.dp)
                    .padding(8.dp)
            )

            Text(
                text = "Pokedex",
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color.White
            )
        }


    }
}