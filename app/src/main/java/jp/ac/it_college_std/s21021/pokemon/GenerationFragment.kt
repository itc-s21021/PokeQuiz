package jp.ac.it_college_std.s21021.pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import jp.ac.it_college_std.s21021.pokemon.databinding.FragmentGenerationBinding

class GenerationFragment : Fragment() {
    private var _binding: FragmentGenerationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenerationBinding.inflate(inflater, container, false)
        val element = pokemondexJson
        binding.world.setOnClickListener {
            val list = element.pokedex[0].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.kanto.setOnClickListener {
            val list = element.pokedex[1].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.zyouto.setOnClickListener {
            val list = element.pokedex[2].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.houen.setOnClickListener {
            val list = element.pokedex[3].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.sinou.setOnClickListener {
            val list = element.pokedex[4].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.issyu.setOnClickListener {
            val list = element.pokedex[5].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.sentoraru.setOnClickListener {
            val list = element.pokedex[6].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.kosuto.setOnClickListener {
            val list = element.pokedex[7].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.maunten.setOnClickListener {
            val list = element.pokedex[8].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.arora.setOnClickListener {
            val list = element.pokedex[9].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.gararu.setOnClickListener {
            val list = element.pokedex[10].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.yoroi.setOnClickListener {
            val list = element.pokedex[11].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.kanmuri.setOnClickListener {
            val list = element.pokedex[12].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }
        binding.hisui.setOnClickListener {
            val list = element.pokedex[13].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list)
            )
        }

//                R.id.generationFragment
        return binding.root
    }
}