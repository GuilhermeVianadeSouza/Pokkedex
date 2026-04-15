package com.aulaandroid.pokedex.service

import com.aulaandroid.pokedex.model.Pokemon
import com.aulaandroid.pokedex.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexService {

    @GET ("pokemon/{busca}/")
    suspend fun buscarPokemon(
        @Path("busca") idOuNome: String
    ) : Response<Pokemon>

    @GET ("pokemon")
    suspend fun buscarListaPokemon(
        @Query("offset") offset: Int = 20,
        @Query("limit") limit: Int = 0
    ): Response<PokemonListResponse>
}