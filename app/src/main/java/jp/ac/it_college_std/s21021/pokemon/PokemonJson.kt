package jp.ac.it_college_std.s21021.pokemon

data class Pokemon(
    val id: Int,
    val name: String,
)
data class PokemonJson(
    val pokemon: List<Pokemon>
)
