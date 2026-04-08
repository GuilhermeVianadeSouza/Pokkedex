package com.aulaandroid.pokedex.service

import com.aulaandroid.pokedex.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexService {

    @GET ("pokemon/{busca}/")
    suspend fun buscarPokemon(
        @Path("busca") idOuNome: String
    ) : Response<Pokemon>
}