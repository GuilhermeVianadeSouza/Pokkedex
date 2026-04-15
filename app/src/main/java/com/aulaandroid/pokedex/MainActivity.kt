package com.aulaandroid.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                    val lista by viewModelCompartilhado.listaPokemon.collectAsState()

                    NavHost(
                        navController = navController,
                        startDestination = "Pokedex",
                        modifier = Modifier.padding(innerPadding),
                        exitTransition ={
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween ( 2000)
                            ) + fadeOut(animationSpec = tween(500))
                        }
                    ){
                    composable(
                        route = "Pokedex",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween (2000)
                            )
                        }
                    )
                    {
                    PokedexScreen(
                        navController = navController,
                        pokemonList = lista,
                        viewModelCompartilhado = viewModelCompartilhado
                    )}
                    }
                }
            }
        }
    }
}