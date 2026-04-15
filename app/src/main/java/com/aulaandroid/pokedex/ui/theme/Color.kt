package com.aulaandroid.pokedex.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

enum class PokemonType(val typeName: String, val color: Color){
    GRASS("grass", Color(0xFF78C850)),
    FIRE("fire", Color(0xFFF08030)),
    WATER("water", Color(0xFF6890F0)),
    BUG("bug", Color(0xFFA8B820)),
    FLYING("flying", Color(0xFFA890F0)),
    POISON("poison", Color(0xFFA040A0)),
    GHOST("ghost", Color(0xFF705898)),
    PSYCHIC("psychic", Color(0xFFF85888)),
    FIGHTING("fighting", Color(0xFFC03028)),
    STEEL("steel", Color(0xFFB8B8D0)),
    DARK("dark", Color(0xFF705848)),
    DRAGON("dragon", Color(0xFF7038F8)),
    FAIRY("fairy", Color(0xFFEE99AC)),
    ICE("ice", Color(0xFF98D8D8)),
    ROCK("rock", Color(0xFFB8A038)),
    GROUND("ground", Color(0xFFE0C068)),
    ELECTRIC("electric", Color(0xFFF8D030)),
    NORMAL("normal", Color(0xFFA8A878))
}

fun obterCorPorTipo(tipo: String?): Color {
    val tipoEncontrado = PokemonType.entries.find {
        it.typeName == tipo?.lowercase()
    }
    return tipoEncontrado?.color ?: Color.Gray
}

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)