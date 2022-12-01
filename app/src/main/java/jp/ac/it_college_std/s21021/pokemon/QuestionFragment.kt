package jp.ac.it_college_std.s21021.pokemon

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.UiThread
import androidx.annotation.WorkerThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.picasso.Picasso
import jp.ac.it_college_std.s21021.pokemon.QuestionFragmentDirections.QuizToQuiz
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.pokemon.setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_ATOP)
        val num = args.pokemonid.random()
        val answername = pokemonJson.pokemon.filter { p ->p.id == num}[0].name
        showPokemonInfo(num)
        val qCount = args.qCount
        var score = args.score
        binding.tvQCount.text = getString(R.string.q_count, qCount)
        var click = false

        class ClickListener(val right: Boolean) : View.OnClickListener{
            override fun onClick(v: View?) {
                if (binding.pokemon.drawable == null){
                    return
                }
                click = true
                if (right) {
                    score++
                    Toast.makeText(context, "正解⭕", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context,getString(R.string.toast_miss,answername), Toast.LENGTH_SHORT).show()
                }
                val a = requireActivity() as MainActivity
                val navHost =
                    a.supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
                if (qCount < 10){
                    navHost.navController.navigate(
                        QuestionFragmentDirections.quizToQuiz(
                            args.pokemonid,
                            args.hardmode
                        ).apply {
                            setQCount(qCount + 1)
                            setScore(score)
                        }
                    )
                }else {
                    navHost.navController.navigate(
                        QuestionFragmentDirections.quizToResult(score, args.hardmode)
                    )
                }
            }
        }

        if (!args.hardmode) {
            binding.etAnswer.visibility = View.INVISIBLE
            binding.btAnswer.visibility = View.INVISIBLE
            val list = listOf(
                binding.b1,
                binding.b2,
                binding.b3,
                binding.b4
            ).shuffled()

            list[0].text = pokemonJson.pokemon.filter { p -> p.id == num }[0].name
            list[1].text = pokemonJson.pokemon.filter { p -> p.id != num }.random().name
            list[2].text = pokemonJson.pokemon.filter { p -> p.id != num }.random().name
            list[3].text = pokemonJson.pokemon.filter { p -> p.id != num }.random().name

            list[0].setOnClickListener(ClickListener(true))
            list[1].setOnClickListener(ClickListener(false))
            list[2].setOnClickListener(ClickListener(false))
            list[3].setOnClickListener(ClickListener(false))
        }else{
            binding.b1.visibility = View.INVISIBLE
            binding.b2.visibility = View.INVISIBLE
            binding.b3.visibility = View.INVISIBLE
            binding.b4.visibility = View.INVISIBLE
            

            binding.btAnswer.setOnClickListener {
                val answer = binding.etAnswer.text.toString()
                if (answer.isEmpty()) {
                    return@setOnClickListener
                }
                ClickListener(answername == answer).onClick(null)
            }
        }
        val h =Handler(Looper.getMainLooper())
        h.postDelayed(object : Runnable {
            var count = if (args.hardmode) 40 else 10
            override fun run() {
                if (click) {
                return
                }
                if (count <= 0) {
                    ClickListener(false).onClick(null)
                    return
                }
                binding.tvTimer.text = getString(R.string.timer, count)
                count --

                h.postDelayed(this, 1000L)
            }
        },0L)
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
