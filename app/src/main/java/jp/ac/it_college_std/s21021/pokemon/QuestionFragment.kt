package jp.ac.it_college_std.s21021.pokemon

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import androidx.annotation.WorkerThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.picasso.Picasso
import jp.ac.it_college_std.s21021.pokemon.databinding.FragmentQuestionBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val BASE_URL = "https://pokeapi.co/api/v2/"
    val args:QuestionFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        binding.pokemon.setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_ATOP)
        val num = args.pokemonid.random()
        showPokemonInfo(num)
        binding.b1.text= pokemonJson.pokemon.filter { p -> p.id == num } [0].name
        binding.b2.text= pokemonJson.pokemon.filter { p -> p.id != num}.random().name
        binding.b3.text= pokemonJson.pokemon.filter { p -> p.id != num}.random().name
        binding.b4.text= pokemonJson.pokemon.filter { p -> p.id != num}.random().name
        return binding.root
    }
    @UiThread
    private fun showPokemonInfo(id: Int){
        lifecycleScope.launch {
            val info =getPokemonInfo(id)
            val url = info.sprites.other.officialArtwork.frontDefault
            Picasso.get().load(url).into(binding.pokemon)
        }
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    @WorkerThread
    private suspend fun getPokemonInfo(id: Int): PokemonInfo {
        return withContext(Dispatchers.IO) {
            val retrofit = Retrofit.Builder().apply {
                baseUrl(BASE_URL)
                addConverterFactory(MoshiConverterFactory.create(moshi))
            }.build()
            val service: PokemonService = retrofit.create(PokemonService::class.java)
            service.fetchPokemon(id).execute().body() ?: throw IllegalStateException("ポケモンが見つかりません")
        }
    }
}
