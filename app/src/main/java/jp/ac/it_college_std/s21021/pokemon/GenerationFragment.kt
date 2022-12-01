package jp.ac.it_college_std.s21021.pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import jp.ac.it_college_std.s21021.pokemon.databinding.FragmentGenerationBinding

class GenerationFragment : Fragment() {
    private var _binding: FragmentGenerationBinding? = null
    private val binding get() = _binding!!
    private val args: GenerationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenerationBinding.inflate(inflater, container, false)
        val element = pokemondexJson
        binding.world.setOnClickListener {
            val list = element.pokedex[0].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.kanto.setOnClickListener {
            val list = element.pokedex[1].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.zyouto.setOnClickListener {
            val list = element.pokedex[2].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.houen.setOnClickListener {
            val list = element.pokedex[3].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.sinou.setOnClickListener {
            val list = element.pokedex[4].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.issyu.setOnClickListener {
            val list = element.pokedex[5].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.sentoraru.setOnClickListener {
            val list = element.pokedex[6].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.kosuto.setOnClickListener {
            val list = element.pokedex[7].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.maunten.setOnClickListener {
            val list = element.pokedex[8].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.arora.setOnClickListener {
            val list = element.pokedex[9].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.gararu.setOnClickListener {
            val list = element.pokedex[10].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.yoroi.setOnClickListener {
            val list = element.pokedex[11].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.kanmuri.setOnClickListener {
            val list = element.pokedex[12].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }
        binding.hisui.setOnClickListener {
            val list = element.pokedex[13].entries.map { e -> e.pokemon_id }.toIntArray()
            Navigation.findNavController(it).navigate(
                GenerationFragmentDirections.actionGenerationFragmentToQuestionFragment(list, args.hardmode)
            )
        }

//                R.id.generationFragment
        return binding.root
    }
}