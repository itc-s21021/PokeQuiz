package jp.ac.it_college_std.s21021.pokemon

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon/{id}/")
    fun fetchPokemon(@Path("id") id: Int): Call<PokemonInfo>
}