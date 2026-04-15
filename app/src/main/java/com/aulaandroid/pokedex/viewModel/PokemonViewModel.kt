package com.aulaandroid.pokedex.viewModel

import android.util.Log
import android.util.Log.e
import android.util.Log.i
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aulaandroid.pokedex.model.Pokemon
import com.aulaandroid.pokedex.service.RetrofitFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel(){
    private val _listaPokemon = MutableStateFlow<List<Pokemon>>(emptyList())
    val listaPokemon: StateFlow<List<Pokemon>> = _listaPokemon.asStateFlow()
    private val pokedexService = RetrofitFactory().getPokedexService()

    private var currentOffset = 0
    private val limit = 20
    var isLoading = false
        private set

    init {
        carregarListaPokemon()
    }

    public fun carregarListaPokemon() {
        if (isLoading) return

        viewModelScope.launch {
            isLoading = true
            try {
                    val response = pokedexService.buscarListaPokemon(limit = limit, offset = currentOffset)
                    if (response.isSuccessful){
                        val resultados = response.body()?.results ?: emptyList()
                        val listaTemporaria = mutableStateListOf<Pokemon>()
                        for (resultado in resultados){
                            val detalheResponse = pokedexService.buscarPokemon(resultado.name)
                            if (detalheResponse.isSuccessful){
                                detalheResponse.body()?.let { pokemonDetalhe ->
                                    listaTemporaria.add((pokemonDetalhe))
                                }
                            }
                        }
                        _listaPokemon.value = listaPokemon.value + listaTemporaria
                        currentOffset += limit
                    }
            } catch (e: Exception){
                Log.e("API_FALHA", "Falhou a conexao malandro: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
}