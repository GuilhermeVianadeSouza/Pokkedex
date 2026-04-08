package com.aulaandroid.pokedex.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializer
import kotlin.collections.map

data class Pokemon(
    val id: Int,
    val name: String,
    val order: Int,
    val height: Int,
    val weight: Int,
    val abilities : List<PokemonAbility>,
    val types: List<PokemonType>,
    val stats: List<PokemonStat>
) {
 val nomesDasHabilidades: List<String>
     get() = abilities.map {it.ability.name}

 val nomesDosTipos: List<String>
     get() = types.map {it.type.name}

    val statusFormatados: List<Pair<String, Int>>
        get() = stats.map { Pair(it.stat.name, it.baseStat) }
}

data class NamedAPIResource(
    val name: String
)

data class PokemonAbility(
    val ability: NamedAPIResource,
)

data class PokemonType(
    val type: NamedAPIResource
)

data class PokemonStat(
    @SerializedName("base_stat")
    val baseStat: Int,
    val stat: NamedAPIResource
)
