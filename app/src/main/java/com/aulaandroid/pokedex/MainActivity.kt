package com.aulaandroid.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.aulaandroid.pokedex.screen.PokedexScreen
import com.aulaandroid.pokedex.ui.theme.PokedexTheme
import com.aulaandroid.pokedex.viewModel.PokemonViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val viewModelCompartilhado : PokemonViewModel = viewModel()

                    NavHost(
                        navController = navController,
                        startDestination = "Pokedex",
                        modifier = Modifier.padding(innerPadding),
                        exitTransition ={}
                    )

                    PokedexScreen(
                        navController = navController
                    )
                }
            }
        }
    }
}